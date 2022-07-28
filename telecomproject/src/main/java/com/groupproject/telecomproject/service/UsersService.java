package com.groupproject.telecomproject.service;

import java.util.List;

import com.groupproject.telecomproject.entity.Users;

public interface UsersService {
    public List<Users> findAll();

    public Users save(Users user);

    public List<Users> findByUser(int userId);
    
}
