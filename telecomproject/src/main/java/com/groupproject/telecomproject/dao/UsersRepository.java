package com.groupproject.telecomproject.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupproject.telecomproject.entity.Users;



public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}
