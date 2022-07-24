package com.groupproject.telecomproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupproject.telecomproject.entity.Physical_devices;
import com.groupproject.telecomproject.service.Physical_devicesService;


@RestController
@RequestMapping("/api")
public class Physical_devicesRestController {

    private Physical_devicesService physical_devicesService;

    @Autowired
    public Physical_devicesRestController(Physical_devicesService thePhysical_devicesService) {
        physical_devicesService = thePhysical_devicesService;
    }

    //expose "/physical_devices" and return list of physical_devices
    @GetMapping("/physical_devices")
    public List<Physical_devices> findAll() {
        return physical_devicesService.findAll();
    }

    // add mapping for GET /physical_devices/{physical_deviceid}
    @GetMapping("/physical_devices/{physical_deviceid}")
    public Physical_devices getPhysical_devices(@PathVariable int physical_deviceid) {
        Physical_devices physical_device = physical_devicesService.findById(physical_deviceid);
    //throw exception if physical_deviceid not found
        if (physical_device == null){
            throw new RuntimeException("physical_deviceid Not Found" + physical_deviceid);
        }

        return physical_device;
    }

    // add mapping for POST /physical_devices - add new physical_device
    @PostMapping("/physical_devices")
    public Physical_devices addPhysical_device (@RequestBody Physical_devices physical_device){
        //also just in case they pass an id in JSON... set id to 0
        //this is to force a save of new item...instead of update

        physical_device.setPhysical_deviceid(0);

        physical_devicesService.save(physical_device);
        return physical_device;
    }

    // add mapping for PUT /physical_devices - update existing physical_device
    @PutMapping("/physical_devices")
    public Physical_devices updatePhysical_device ( @RequestBody Physical_devices physical_device){
        physical_devicesService.save(physical_device);
        return physical_device;
    }

    // add mapping for DELETE /physical_devices/{physical_deviceid} - delete physical_device
    @DeleteMapping("/physical_devices/{physical_deviceid}")
    public String deletePhysical_device (@PathVariable int physical_deviceid){
        Physical_devices tempPhysical_device = physical_devicesService.findById(physical_deviceid);
    // throw exception if physical_deviceid not found
    if (tempPhysical_device == null){
        throw new RuntimeException("physical_deviceid Not Found" + physical_deviceid);
    }

    physical_devicesService.deleteById(physical_deviceid);
    return "Deleted physical_device with id: " + physical_deviceid;
    }
}