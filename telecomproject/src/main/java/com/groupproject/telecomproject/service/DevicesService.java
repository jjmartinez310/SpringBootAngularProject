package com.groupproject.telecomproject.service;

import java.util.List;

import com.groupproject.telecomproject.entity.Devices;

public interface DevicesService {
    public List<Devices> findAll();

    public Devices save(Devices device);

    public void delete(String name);

    public List<Devices> findByPlan(int planId); 
}