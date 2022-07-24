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

import com.groupproject.telecomproject.entity.Phone_plans;
import com.groupproject.telecomproject.service.Phone_plansService;


@RestController
@RequestMapping("/api")
public class Phone_plansRestController {

    private Phone_plansService phone_plansService;

    @Autowired
    public Phone_plansRestController(Phone_plansService thePhone_plansService) {
        phone_plansService = thePhone_plansService;
    }

    //expose "/phone_plans" and return list of phone_plans
    @GetMapping("/phone_plans")
    public List<Phone_plans> findAll() {
        return phone_plansService.findAll();
    }

    // add mapping for GET /phone_plans/{phone_planid}
    @GetMapping("/phone_plans/{phone_planid}")
    public Phone_plans getPhone_plans(@PathVariable int phone_planid) {
        Phone_plans phone_plan = phone_plansService.findById(phone_planid);
    //throw exception if phone_planid not found
        if (phone_plan == null){
            throw new RuntimeException("phone_planid Not Found" + phone_planid);
        }

        return phone_plan;
    }

    // add mapping for POST /phone_plans - add new phone_plan
    @PostMapping("/phone_plans")
    public Phone_plans addPhone_plan (@RequestBody Phone_plans phone_plan){
        //also just in case they pass an id in JSON... set id to 0
        //this is to force a save of new item...instead of update

        phone_plan.setPhone_planid(0);

        phone_plansService.save(phone_plan);
        return phone_plan;
    }

    // add mapping for PUT /phone_plans - update existing phone_plan
    @PutMapping("/phone_plans")
    public Phone_plans updatePhone_plan ( @RequestBody Phone_plans phone_plan){
        phone_plansService.save(phone_plan);
        return phone_plan;
    }

    // add mapping for DELETE /phone_plans/{phone_planid} - delete phone_plan
    @DeleteMapping("/phone_plans/{phone_planid}")
    public String deletePhone_plan (@PathVariable int phone_planid){
        Phone_plans tempPhone_plan = phone_plansService.findById(phone_planid);
    // throw exception if phone_planid not found
    if (tempPhone_plan == null){
        throw new RuntimeException("phone_planid Not Found" + phone_planid);
    }

    phone_plansService.deleteById(phone_planid);
    return "Deleted phone_plan with id: " + phone_planid;
    }
}