package com.groupproject.telecomproject.service;

import java.util.List;

import com.groupproject.telecomproject.entity.Physical_devices;

public interface Physical_devicesService {
    public List<Physical_devices> findAll();

    public Physical_devices findById(int id);

    public void save(Physical_devices physical_device);
    
    public void deleteById(int id);
}