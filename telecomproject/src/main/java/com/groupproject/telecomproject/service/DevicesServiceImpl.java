package com.groupproject.telecomproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.groupproject.telecomproject.dao.DevicesRepository;
import com.groupproject.telecomproject.entity.Devices;

@Service
public class DevicesServiceImpl implements DevicesService {

    //Device Repo
	@Autowired
	DevicesRepository repo;
	
	/**
	 * GET all devices
	 */
	public List<Devices> findAll() {
		List<Devices> allDevices = repo.findAll();
		return allDevices;
	}
	
	/**
	 * POST a device
	 */
	public Devices save(Devices device) {
		Devices newDevice = repo.save(device);
		return newDevice;
	}
	
	/**
	 * DELETE a device
	 */
	public void delete(@Param("name") String name) {
		 repo.delete(name);
	}
	
	/**
	 * GET device by plan id
	 */
	public List<Devices> findByPlan(int planId) {
		return repo.findByPlan(planId);
	}
    
}