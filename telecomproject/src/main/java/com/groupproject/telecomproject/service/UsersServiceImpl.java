package com.groupproject.telecomproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupproject.telecomproject.dao.UsersRepository;
import com.groupproject.telecomproject.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {

    //Customer Repo
	@Autowired
	UsersRepository repo;
	
	/**
	 * GET all customers
	 */
	public List<Users> findAll() {
		List<Users> allUsers = repo.findAll();
		return allUsers;
	}
	
	/**
	 * POST a User
	 */
	public Users save(Users user) {
		Users newUser = repo.save(user);
		return newUser;
	}

    public List<Users> findByUser(int userId) {
		return repo.findByUser(userId);
	}
    
}
