package com.groupproject.telecomproject.service;

import java.util.List;

import com.groupproject.telecomproject.entity.Devices;

public interface DevicesService {
    public List<Devices> findAll();

    public Devices findById(int id);

    public void save(Devices device);
    
    public void deleteById(int id);
}