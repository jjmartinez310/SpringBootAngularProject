package com.groupproject.telecomproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.groupproject.telecomproject.entity.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    
    public Users findById(int id);

    public Users findByUsername(String username);
}
