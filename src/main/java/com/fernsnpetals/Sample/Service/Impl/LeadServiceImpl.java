package com.fernsnpetals.Sample.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernsnpetals.Sample.Dao.LeadRepository;
import com.fernsnpetals.Sample.Service.LeadService;
import com.fernsnpetals.Sample.controller.Entity.Lead;

@Service
public class LeadServiceImpl implements LeadService{
    
	@Autowired
	LeadRepository leadRepository;
	
	@Override
	public void saveLead(Lead lead) {
		// TODO Auto-generated method stub
		leadRepository.save(lead);
		
	}

	@Override
	public Lead getLead(int id) {
		// TODO Auto-generated method stub
		Optional<Lead> lead= leadRepository.findById(id);
		
		return lead.get();
	}

	@Override
	public void deleteLead(int id) {
		
		leadRepository.deleteById(id);
		
	}

	@Override
	public void updateLead(Lead lead) {
		// TODO Auto-generated method stub
		
	}

}
