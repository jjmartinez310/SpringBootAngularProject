package com.groupproject.telecomproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.groupproject.telecomproject.entity.Users;
import com.groupproject.telecomproject.service.UsersService;


@RestController
@RequestMapping("/users")
public class UsersRestController {
    //Customer service
	@Autowired
	UsersService service;
	
	/**
	 * GET all users
	 */
	@GetMapping
	public ResponseEntity<List<Users>> findAll() {
		List<Users> allCustomers = service.findAll();
		return new ResponseEntity<>(allCustomers, HttpStatus.OK);
	}
	
	/**
	 * POST a user
	 */
	@PostMapping("new")	
	public ResponseEntity<Users> save(@RequestBody Users user) {
		Users newUser = service.save(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED); 
	} 

    /**
	 * GET all by user id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<List<Users>> findByUser(@PathVariable("id") int id) {
		System.out.println("findByUser() " + id);
		return new ResponseEntity<List<Users>>(service.findByUser(id), HttpStatus.OK);
	}
}
