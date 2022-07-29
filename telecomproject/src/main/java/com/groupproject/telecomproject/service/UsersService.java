package com.groupproject.telecomproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.groupproject.telecomproject.dao.UsersRepository;
import com.groupproject.telecomproject.entity.Users;

@Service
public class UsersService {
    
    @Autowired
    private UsersRepository repository;
    
    public Users findById(int id){
		return repository.findById(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Users add(Users user) {
		return repository.save(user);
	}

	@Transactional()
	public void delete(int user_id) {
		repository.delete(findById(user_id));
	}

	public Users findByUsername(String username) {
		return repository.findByUsername(username);
	}
}
