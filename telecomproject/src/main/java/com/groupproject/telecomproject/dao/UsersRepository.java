package com.groupproject.telecomproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupproject.telecomproject.entity.Users;



public interface UsersRepository extends JpaRepository<Users, Integer> {
    
}
