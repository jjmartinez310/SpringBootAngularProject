package com.groupproject.telecomproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.groupproject.telecomproject.entity.Devices;


@Repository
public interface DevicesRepository extends JpaRepository<Devices, Integer> {

    /**
	 * GET all by plan id
	 */
	@Query(value = "select * from devices where plan_id = ?", nativeQuery = true)	
	public List<Devices> findByPlan(int planId);
	
	/**
	 * DELETE by device name
	 */
	@Modifying
    @Transactional
	@Query(value = "delete from devices where devices.device_name = ?", nativeQuery = true)	
	public void delete(@Param("name") String name);
    
}