package com.groupproject.telecomproject.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.groupproject.telecomproject.entity.Users;

public class MyUserDetails implements UserDetails {
    private String user_id;
    private String username;
    private String pass;
    private String first_name;
    private String last_name;

    public MyUserDetails(Users users) {
        this.username = users.getUsername();
        this.pass = users.getPass();
        this.first_name = users.getFirst_name();
        this.last_name = users.getLast_name();
    }

    public MyUserDetails() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return pass;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
