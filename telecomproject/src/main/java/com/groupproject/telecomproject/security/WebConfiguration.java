package com.groupproject.telecomproject.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Order(1)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = false, prePostEnabled = true, securedEnabled = false)
public class WebConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }
	@Bean
    public SessionRegistry sessionRegistry( ) {
        SessionRegistry sessionRegistry = new SessionRegistryImpl( );
        return sessionRegistry;
    }
    @Bean
    public RegisterSessionAuthenticationStrategy registerSessionAuthStr( ) {
        return new RegisterSessionAuthenticationStrategy( sessionRegistry( ) );
    }
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configuring");
		
		http
				.cors()
				.and()
				.authorizeRequests()
				.antMatchers("/users/signup").anonymous()
				.antMatchers("/**").hasAnyAuthority("USER", "ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.defaultSuccessUrl("/users/authed")
				.successHandler(successHandler())
				.failureHandler(failureHandler())
				.and().rememberMe().and()
				.logout().deleteCookies("JSESSIONID").logoutUrl("/logout").invalidateHttpSession(true) ;
				
		http
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(1)
				.maxSessionsPreventsLogin(true);
				

		http.csrf().disable();
	}

	private AuthenticationSuccessHandler successHandler() {
		return new AuthenticationSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse, Authentication authentication)
					throws IOException, ServletException {
				System.out.println("Login successful");
				httpServletResponse.setStatus(200);
			}
		};
	}

	private AuthenticationFailureHandler failureHandler() {
		return new AuthenticationFailureHandler() {
			@Override
			public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse, AuthenticationException e)
					throws IOException, ServletException {
				System.out.println("Login Failure");
				httpServletResponse.setStatus(401);
			}
		};
	}

}
