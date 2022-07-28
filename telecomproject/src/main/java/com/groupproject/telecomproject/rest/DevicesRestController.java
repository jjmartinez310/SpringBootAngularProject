package com.groupproject.telecomproject.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupproject.telecomproject.entity.Devices;
import com.groupproject.telecomproject.service.DevicesService;


@RestController
@RequestMapping("/devices")
public class DevicesRestController {

    //Devices service
	@Autowired
	DevicesService service;
	
	/**
	 * GET all devices
	 */
	@GetMapping
	public ResponseEntity<List<Devices>> findAll() {
		List<Devices> allDevices = service.findAll();
		return new ResponseEntity<>(allDevices, HttpStatus.OK);
	}
	
	/**
	 * POST a device
	 */
	@PostMapping("add")
	public ResponseEntity<Devices> save(@RequestBody Devices device) {
		System.out.println("save() " + device);
		Devices newDevice = service.save(device);
		return new ResponseEntity<>(newDevice, HttpStatus.CREATED); 		
	}
	
	/**
	 * DELETE a device by name
	 */
	@DeleteMapping("/{name}")
	public void delete(@PathVariable("name") String name) {
		System.out.println("delete() " + name);
		 service.delete(name);
	}
	
	/**
	 * GET all by plan id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<List<Devices>> findByPlan(@PathVariable("id") int id) {
		System.out.println("findByPlan() " + id);
		return new ResponseEntity<List<Devices>>(service.findByPlan(id), HttpStatus.OK);
	}
}