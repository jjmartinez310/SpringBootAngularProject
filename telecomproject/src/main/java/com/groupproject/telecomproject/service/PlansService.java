package com.groupproject.telecomproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.groupproject.telecomproject.entity.Plans;
import com.groupproject.telecomproject.dao.PlansRepository;

@Service
public class PlansService {
	
	@Autowired
	private PlansRepository repository;
	
	public Plans findById(int id){
		return repository.findById(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Plans add(Plans plan) {
		return repository.save(plan);
	}

	@Transactional()
	public void delete(int planId) {
		repository.delete(findById(planId));
	}

	public List<Plans> findPlanByUserId(int userId) {
		return repository.findPlanByUserId(userId);
	}
}