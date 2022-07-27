package com.groupproject.telecomproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupproject.telecomproject.entity.Devices;



public interface DevicesRepository extends JpaRepository<Devices, Integer> {
    
}