package com.groupproject.telecomproject.service;

import java.util.List;

import com.groupproject.telecomproject.entity.Phone_plans;

public interface Phone_plansService {
    public List<Phone_plans> findAll();

    public Phone_plans findById(int id);

    public void save(Phone_plans phone_plan);
    
    public void deleteById(int id);
}