package com.groupproject.telecomproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupproject.telecomproject.dao.Phone_plansRepository;
import com.groupproject.telecomproject.entity.Phone_plans;

@Service
public class Phone_plansServiceImpl implements Phone_plansService {

    private Phone_plansRepository phone_plansRepository;
    
    @Autowired
    public Phone_plansServiceImpl (Phone_plansRepository thePhone_plansRepository){
        phone_plansRepository = thePhone_plansRepository;
    }

    @Override
    public List<Phone_plans> findAll() {
        return phone_plansRepository.findAll();
    }

    @Override
    public Phone_plans findById(int id) {
        Optional<Phone_plans> result = phone_plansRepository.findById(id);

        Phone_plans thePhone_plans = null;
        
        if (result.isPresent()) {
            thePhone_plans = result.get();
        }
        else {
            throw new RuntimeException("Did not find phone_plan id");
        }
        return thePhone_plans;
    }

    @Override
    public void save(Phone_plans phone_plan) {
        phone_plansRepository.save(phone_plan);
        
    }

    @Override
    public void deleteById(int id) {
        phone_plansRepository.deleteById(id);
        
    }
    
}