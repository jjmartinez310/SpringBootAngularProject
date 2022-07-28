package com.groupproject.telecomproject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.groupproject.telecomproject.entity.Plans;

@Repository
public interface PlansRepository extends JpaRepository<Plans, Integer> {

    /**
	 * GET all by plan id
	 */
	@Query(value = "select * from plans where user_id = ?", nativeQuery = true)	
	public List<Plans> findByUser(int userId);
    

    /**
	 * DELETE by plan id
	 */
    @Modifying
    @Transactional
    @Query(value = "delete from plans where plans.plan_id = ?", nativeQuery = true)
    public void delete(@Param("id") int id);
}