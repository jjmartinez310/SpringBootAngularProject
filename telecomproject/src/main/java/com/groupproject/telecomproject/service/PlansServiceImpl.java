package com.groupproject.telecomproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupproject.telecomproject.dao.PlansRepository;
import com.groupproject.telecomproject.entity.Plans;

@Service
public class PlansServiceImpl implements PlansService {

    private PlansRepository plansRepository;
    
    @Autowired
    public PlansServiceImpl (PlansRepository thePlansRepository){
        plansRepository = thePlansRepository;
    }

    @Override
    public List<Plans> findAll() {
        return plansRepository.findAll();
    }

    @Override
    public Plans findById(int id) {
        Optional<Plans> result = plansRepository.findById(id);

        Plans thePlans = null;
        
        if (result.isPresent()) {
            thePlans = result.get();
        }
        else {
            throw new RuntimeException("Did not find plan id");
        }
        return thePlans;
    }

    @Override
    public void save(Plans plan) {
        plansRepository.save(plan);
        
    }

    @Override
    public void deleteById(int id) {
        plansRepository.deleteById(id);
        
    }
    
}