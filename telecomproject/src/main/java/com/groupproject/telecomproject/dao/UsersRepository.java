package com.groupproject.telecomproject.dao;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.groupproject.telecomproject.entity.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);

    @Query(value = "select * from users where user_id = ?", nativeQuery = true)	
	public List<Users> findByUser(int userId);
}
