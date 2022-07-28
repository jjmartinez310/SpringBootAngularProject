package com.groupproject.telecomproject.service;

import java.util.List;

import com.groupproject.telecomproject.entity.Plans;

public interface PlansService {
    public List<Plans> findAll();

    public Plans save(Plans plan);
    
    public void delete(int id);

    public List<Plans> findByUser(int userId);
}