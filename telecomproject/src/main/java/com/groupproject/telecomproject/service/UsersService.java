package com.groupproject.telecomproject.service;

import java.util.List;

import com.groupproject.telecomproject.entity.Users;

public interface UsersService {
    public List<Users> findAll();

    public Users findById(int id);

    public void save(Users user);
    
    public void deleteById(int id);
}
