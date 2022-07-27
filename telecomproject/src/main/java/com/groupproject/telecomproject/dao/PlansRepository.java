package com.groupproject.telecomproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupproject.telecomproject.entity.Plans;



public interface PlansRepository extends JpaRepository<Plans, Integer> {
    
}