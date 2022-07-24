package com.groupproject.telecomproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupproject.telecomproject.dao.Physical_devicesRepository;
import com.groupproject.telecomproject.entity.Physical_devices;

@Service
public class Physical_devicesServiceImpl implements Physical_devicesService {

    private Physical_devicesRepository physical_devicesRepository;
    
    @Autowired
    public Physical_devicesServiceImpl (Physical_devicesRepository thePhysical_devicesRepository){
        physical_devicesRepository = thePhysical_devicesRepository;
    }

    @Override
    public List<Physical_devices> findAll() {
        return physical_devicesRepository.findAll();
    }

    @Override
    public Physical_devices findById(int id) {
        Optional<Physical_devices> result = physical_devicesRepository.findById(id);

        Physical_devices thePhysical_devices = null;
        
        if (result.isPresent()) {
            thePhysical_devices = result.get();
        }
        else {
            throw new RuntimeException("Did not find physical_device id");
        }
        return thePhysical_devices;
    }

    @Override
    public void save(Physical_devices physical_device) {
        physical_devicesRepository.save(physical_device);
        
    }

    @Override
    public void deleteById(int id) {
        physical_devicesRepository.deleteById(id);
        
    }
    
}