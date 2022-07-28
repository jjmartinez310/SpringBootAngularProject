package com.groupproject.telecomproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.groupproject.telecomproject.dao.PlansRepository;
import com.groupproject.telecomproject.entity.Plans;

@Service
public class PlansServiceImpl implements PlansService {

    //Plan Repo
	@Autowired
	PlansRepository repo;
	
	/**
	 * GET all plans
	 */
	public List<Plans> findAll() {
		List<Plans> allPlans = repo.findAll();
		return allPlans;
	}
	
	/**
	 * POST a plan
	 */
	public Plans save(Plans plan) {
		Plans newPlan = repo.save(plan);
		return newPlan;
	}
	
	/**
	 * DELETE a plan
	 */
	public void delete(@Param("id") int id) {
		 repo.delete(id);
	}

    /**
	 * GET plans by user id
	 */
	public List<Plans> findByUser(int userId) {
		return repo.findByUser(userId);
	}
    
}