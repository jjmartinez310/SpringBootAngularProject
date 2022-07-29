package com.groupproject.telecomproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.groupproject.telecomproject.entity.Plans;

@Repository
public interface PlansRepository extends JpaRepository<Plans, Integer> {

    public Plans findById(int id);

	public Plans findByPlanName(String planName);

	@Query( "SELECT p FROM Plans p WHERE p.userId = :id" )
    public List<Plans> findPlanByUserId(@Param("id") int id);
}