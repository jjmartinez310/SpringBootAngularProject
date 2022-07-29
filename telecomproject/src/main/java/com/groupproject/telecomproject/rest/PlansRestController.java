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

import com.groupproject.telecomproject.entity.Plans;
import com.groupproject.telecomproject.service.PlansService;

@EnableGlobalMethodSecurity(jsr250Enabled = false, prePostEnabled = true, securedEnabled = false)
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/plans")
public class PlansRestController {

  @Autowired
  PlansService plansService;
    
  @GetMapping("/{id}")
  public ResponseEntity<List<Plans>> findByUserId(@PathVariable("id") int id){
	  
	  try {
		  List<Plans> plans = plansService.findPlanByUserId(id);
		  if(plans == null) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<List<Plans>>(plans, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
    @GetMapping("/plan/{id}")
  public ResponseEntity<Plans> findByPlanId(@PathVariable("id") int id){
	  
	  try {
		  Plans plans = plansService.findById(id);
		  if(plans == null) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<Plans>(plans, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

    @PutMapping("/update/{id}")
  public ResponseEntity<Plans> updateByPlanId(@PathVariable("id") int id, @RequestBody Plans plans){
	  
	  try {
		  Plans newPlan = plansService.findById(id);
		  if(newPlan == null) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
      newPlan.setPlanName(plans.getPlanName());
      newPlan.setPlanPrice(plans.getPlanPrice());
      newPlan.setPlanNumlines(plans.getPlanNumlines());
		  return new ResponseEntity<Plans>(newPlan, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }


  @PostMapping("/newplan")
  public ResponseEntity<Plans> createPlan(@RequestBody Plans plans) {
    Plans _plan = plansService.findById(plans.getId());
    try {
      if(_plan == null) {
        _plan = plansService.add(new Plans(plans.getPlanName(), plans.getPlanNumlines(), plans.getPlanPrice(), plans.getUserId()));
      }
          
      return new ResponseEntity<>(_plan, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deletePlan(@PathVariable("id") int id) {
    try {
        plansService.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}