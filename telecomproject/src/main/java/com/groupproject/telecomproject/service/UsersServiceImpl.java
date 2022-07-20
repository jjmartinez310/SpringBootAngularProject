package com.groupproject.telecomproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupproject.telecomproject.dao.UsersDAO;
import com.groupproject.telecomproject.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersDAO usersDAO;
    
    @Autowired
    public UsersServiceImpl (UsersDAO theUsersDAO){
        usersDAO = theUsersDAO;
    }

    @Override
    @Transactional
    public List<Users> findAll() {
        return usersDAO.findAll();
    }

    @Override
    @Transactional
    public Users findById(int id) {
        return usersDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Users user) {
        usersDAO.save(user);
        
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        usersDAO.deleteById(id);
        
    }
    
}
