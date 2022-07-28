package com.groupproject.telecomproject.security;

import com.groupproject.telecomproject.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.groupproject.telecomproject.dao.UsersRepository;
import com.groupproject.telecomproject.entity.Users;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = usersRepository.findByUsername(username);

        users.orElseThrow(() -> new UsernameNotFoundException("Not found"));

        return users.map(MyUserDetails::new).get();
    }
    
}
