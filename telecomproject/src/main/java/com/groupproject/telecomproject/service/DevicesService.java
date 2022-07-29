package com.groupproject.telecomproject.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.groupproject.telecomproject.entity.Devices;
import com.groupproject.telecomproject.dao.DevicesRepository;;

@Service
public class DevicesService {
	
	@Autowired
	private DevicesRepository repository;
	
	public Devices findById(int id){
		return repository.findById(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Devices add(Devices device) {
		return repository.save(device);
	}

	@Transactional()
	public void delete(int deviceId) {
		repository.delete(findById(deviceId));
	}

	public List<Devices> findDevicesByPlanId(int planId) {
		return repository.findDevicesByPlanId(planId);
	}
}
