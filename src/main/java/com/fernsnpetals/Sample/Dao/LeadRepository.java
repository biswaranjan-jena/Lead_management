package com.fernsnpetals.Sample.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernsnpetals.Sample.controller.Entity.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer>{
	
	

}
