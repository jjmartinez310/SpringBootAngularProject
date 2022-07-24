package com.groupproject.telecomproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupproject.telecomproject.dao.UsersRepository;
import com.groupproject.telecomproject.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;
    
    @Autowired
    public UsersServiceImpl (UsersRepository theUsersRepository){
        usersRepository = theUsersRepository;
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findById(int id) {
        Optional<Users> result = usersRepository.findById(id);

        Users theUsers = null;
        
        if (result.isPresent()) {
            theUsers = result.get();
        }
        else {
            throw new RuntimeException("Did not find user id");
        }
        return theUsers;
    }

    @Override
    public void save(Users user) {
        usersRepository.save(user);
        
    }

    @Override
    public void deleteById(int id) {
        usersRepository.deleteById(id);
        
    }
    
}
