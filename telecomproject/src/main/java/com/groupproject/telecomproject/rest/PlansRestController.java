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

import com.groupproject.telecomproject.entity.Plans;
import com.groupproject.telecomproject.service.PlansService;


@RestController
@RequestMapping("/api")
public class PlansRestController {

    private PlansService plansService;

    @Autowired
    public PlansRestController(PlansService thePlansService) {
        plansService = thePlansService;
    }

    //expose "/plans" and return list of plans
    @GetMapping("/plans")
    public List<Plans> findAll() {
        return plansService.findAll();
    }

    // add mapping for GET /plans/{plan_id}
    @GetMapping("/plans/{plan_id}")
    public Plans getPlans(@PathVariable int plan_id) {
        Plans plan = plansService.findById(plan_id);
    //throw exception if plan_id not found
        if (plan == null){
            throw new RuntimeException("plan_id Not Found" + plan_id);
        }

        return plan;
    }

    // add mapping for POST /plans - add new plan
    @PostMapping("/plans")
    public Plans addPlan (@RequestBody Plans plan){
        //also just in case they pass an id in JSON... set id to 0
        //this is to force a save of new item...instead of update

        plan.setPlan_id(0);

        plansService.save(plan);
        return plan;
    }

    // add mapping for PUT /plans - update existing plan
    @PutMapping("/plans")
    public Plans updatePlan ( @RequestBody Plans plan){
        plansService.save(plan);
        return plan;
    }

    // add mapping for DELETE /plans/{plan_id} - delete plan
    @DeleteMapping("/plans/{plan_id}")
    public String deletePlan (@PathVariable int plan_id){
        Plans tempPlan = plansService.findById(plan_id);
    // throw exception if plan_id not found
    if (tempPlan == null){
        throw new RuntimeException("plan_id Not Found" + plan_id);
    }

    plansService.deleteById(plan_id);
    return "Deleted plan with id: " + plan_id;
    }
}