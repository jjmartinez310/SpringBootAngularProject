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

import com.groupproject.telecomproject.entity.Devices;
import com.groupproject.telecomproject.service.DevicesService;


@RestController
@RequestMapping("/api")
public class DevicesRestController {

    private DevicesService devicesService;

    @Autowired
    public DevicesRestController(DevicesService theDevicesService) {
        devicesService = theDevicesService;
    }

    //expose "/devices" and return list of devices
    @GetMapping("/devices")
    public List<Devices> findAll() {
        return devicesService.findAll();
    }

    // add mapping for GET /devices/{device_id}
    @GetMapping("/devices/{device_id}")
    public Devices getDevices(@PathVariable int device_id) {
        Devices device = devicesService.findById(device_id);
    //throw exception if device_id not found
        if (device == null){
            throw new RuntimeException("device_id Not Found" + device_id);
        }

        return device;
    }

    // add mapping for POST /devices - add new device
    @PostMapping("/devices")
    public Devices addDevice (@RequestBody Devices device){
        //also just in case they pass an id in JSON... set id to 0
        //this is to force a save of new item...instead of update

        device.setDevice_id(0);

        devicesService.save(device);
        return device;
    }

    // add mapping for PUT /devices - update existing device
    @PutMapping("/devices")
    public Devices updateDevice ( @RequestBody Devices device){
        devicesService.save(device);
        return device;
    }

    // add mapping for DELETE /devices/{device_id} - delete device
    @DeleteMapping("/devices/{device_id}")
    public String deleteDevice (@PathVariable int device_id){
        Devices tempDevice = devicesService.findById(device_id);
    // throw exception if device_id not found
    if (tempDevice == null){
        throw new RuntimeException("device_id Not Found" + device_id);
    }

    devicesService.deleteById(device_id);
    return "Deleted device with id: " + device_id;
    }
}