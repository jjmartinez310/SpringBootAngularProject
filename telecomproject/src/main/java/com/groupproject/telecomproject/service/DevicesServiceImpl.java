package com.groupproject.telecomproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupproject.telecomproject.dao.DevicesRepository;
import com.groupproject.telecomproject.entity.Devices;

@Service
public class DevicesServiceImpl implements DevicesService {

    private DevicesRepository devicesRepository;
    
    @Autowired
    public DevicesServiceImpl (DevicesRepository theDevicesRepository){
        devicesRepository = theDevicesRepository;
    }

    @Override
    public List<Devices> findAll() {
        return devicesRepository.findAll();
    }

    @Override
    public Devices findById(int id) {
        Optional<Devices> result = devicesRepository.findById(id);

        Devices theDevices = null;
        
        if (result.isPresent()) {
            theDevices = result.get();
        }
        else {
            throw new RuntimeException("Did not find device id");
        }
        return theDevices;
    }

    @Override
    public void save(Devices device) {
        devicesRepository.save(device);
        
    }

    @Override
    public void deleteById(int id) {
        devicesRepository.deleteById(id);
        
    }
    
}