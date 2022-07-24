package com.groupproject.telecomproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupproject.telecomproject.entity.Physical_devices;



public interface Physical_devicesRepository extends JpaRepository<Physical_devices, Integer> {
    
}