package com.groupproject.telecomproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.groupproject.telecomproject.entity.Devices;


@Repository
public interface DevicesRepository extends JpaRepository<Devices, Integer> {

    public Devices findById(int id);

	public Devices findByDeviceName(String deviceName);

	@Query( "SELECT d FROM Devices d WHERE d.planId = :id" )
    public List<Devices> findDevicesByPlanId(@Param("id") int id);
    
}