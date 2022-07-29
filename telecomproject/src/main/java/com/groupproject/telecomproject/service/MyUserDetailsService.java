package com.groupproject.telecomproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.groupproject.telecomproject.entity.Users;
import com.groupproject.telecomproject.dao.UsersRepository;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
         Users _user = repository.findByUsername(userName);
         
        if (_user == null) {
            throw new UsernameNotFoundException("test");
        }
        // Have to sign in as Admin to Delete anything
        else if(_user.getUsername().equals("barry")) {
            UserDetails user = User.withUsername(_user.getUsername()).password(_user.getPass()).authorities("ADMIN").build();
            System.out.println(_user.getUsername() + " has attempted to login " + user.getAuthorities());
            return user;
        }
        else{
            UserDetails user = User.withUsername(_user.getUsername()).password(_user.getPass()).authorities("USER").build();
            System.out.println(_user.getUsername() + " has attempted to login " + user.getAuthorities());
            return user;
        }
        
    }

    
    
}