package com.fernsnpetals.Sample.Service;

import org.springframework.stereotype.Service;

import com.fernsnpetals.Sample.controller.Entity.Lead;

@Service
public interface LeadService {
	public void saveLead(Lead lead);
	public Lead getLead(int id);
	public void deleteLead(int id);
	public void updateLead(Lead lead);
	

}
