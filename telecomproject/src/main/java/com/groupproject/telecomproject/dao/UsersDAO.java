package com.groupproject.telecomproject.dao;

import java.util.List;
import com.groupproject.telecomproject.entity.Users;

public interface UsersDAO {
    
    public List<Users> findAll();

    public Users findById(int id);

    public void save(Users user);

    public void deleteById(int id);

}
