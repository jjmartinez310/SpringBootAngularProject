package com.groupproject.telecomproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupproject.telecomproject.entity.Devices;
import com.groupproject.telecomproject.service.DevicesService;


@EnableGlobalMethodSecurity(jsr250Enabled = false, prePostEnabled = true, securedEnabled = false)
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/devices")
public class DevicesRestController {

  @Autowired
  DevicesService devicesService;

  @GetMapping("/{id}")
  public ResponseEntity<List<Devices>> findById(@PathVariable("id") int id){
	  
	  try {
		  List<Devices> devices = devicesService.findDevicesByPlanId(id);
		  if(devices == null) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<List<Devices>>(devices, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
  
  @PostMapping("/newdevice")
  public ResponseEntity<Devices> createDevice(@RequestBody Devices device) {
    
    Devices _device = devicesService.findById(device.getId());
    try {
      if(_device == null){
        _device = devicesService.add(new Devices(device.getDeviceName(), device.getDeviceNumber(), device.getDeviceModel(), device.getPlanId()));
        return new ResponseEntity<>(_device, HttpStatus.CREATED);
      }
      else{
        return new ResponseEntity<>(_device, HttpStatus.BAD_REQUEST);
      }
       
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @PutMapping("/update/{id}")
  public ResponseEntity<Devices> updateDevice(@PathVariable("id") int id, @RequestBody Devices device) {
    Devices deviceData = devicesService.findById(id);
    if (deviceData != null) {
        deviceData.setDeviceName(device.getDeviceName());
        deviceData.setDeviceNumber(device.getDeviceNumber());
		deviceData.setDeviceModel(device.getDeviceModel());
        deviceData.setPlanId(device.getPlanId());
      return new ResponseEntity<>(devicesService.add(deviceData), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteDevice(@PathVariable("id") int id) {
    try {
        devicesService.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}