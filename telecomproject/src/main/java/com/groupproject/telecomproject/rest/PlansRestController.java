package com.groupproject.telecomproject.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupproject.telecomproject.entity.Plans;
import com.groupproject.telecomproject.service.PlansService;


@RestController
@RequestMapping("/plans")
public class PlansRestController {

    @Autowired
	PlansService service;
	
	/**
	 * GET all plans
	 */
	@GetMapping
	public ResponseEntity<List<Plans>> findAll() {
		List<Plans> allPlans = service.findAll();
		
		return new ResponseEntity<>(allPlans, HttpStatus.OK);
	}
	
	/**
	 * POST a plan
	 */
	@PostMapping("/new")
	public ResponseEntity<Plans> save(@RequestBody Plans plan) {
		System.out.println("save() " + plan);
		
		Plans newPlan = service.save(plan);
		
		return new ResponseEntity<>(newPlan, HttpStatus.CREATED); 		
	}
	
	/**
	 * DELETE a plan by id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		System.out.println("delete() " + id);
		 service.delete(id);
	}

    /**
	 * GET all by user id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<List<Plans>> findByUser(@PathVariable("id") int id) {
		System.out.println("findByUser() " + id);
		return new ResponseEntity<List<Plans>>(service.findByUser(id), HttpStatus.OK);
	}
}