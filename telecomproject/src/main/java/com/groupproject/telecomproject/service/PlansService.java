package com.groupproject.telecomproject.service;

import java.util.List;

import com.groupproject.telecomproject.entity.Plans;

public interface PlansService {
    public List<Plans> findAll();

    public Plans findById(int id);

    public void save(Plans plan);
    
    public void deleteById(int id);
}