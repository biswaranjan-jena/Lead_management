 package com.fernsnpetals.Sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fernsnpetals.Sample.Service.LeadService;
import com.fernsnpetals.Sample.controller.Entity.Lead;
import com.fernsnpetals.Sample.model.Response;

@RestController()
@RequestMapping("/api/lead")
public class LeadController {
	@Autowired
	private LeadService leadServices;
	Lead l;
	Response res=null;
	
	
	
	
	
	@GetMapping("/{leadId}")
	 public ResponseEntity<Object> getLead(@PathVariable(name="leadId")int leadId) {
	  Lead employees = leadServices.getLead(leadId);
	  
	  return ResponseEntity.ok(HttpStatus.OK);
	 }
	@PostMapping("/addLead")
	public ResponseEntity<Response> saveLead(Lead lead) {
		
		res=new Response();
		leadServices.saveLead(lead);
		if(lead.getEmail()==null) {
			res.setReason("bad request");
			res.setStatus(HttpStatus.BAD_REQUEST);
			return ResponseEntity.badRequest().body(res);
		}else {
			res.setStatus(HttpStatus.OK);
			return ResponseEntity.ok().body(res);
		}
		
		
		
		
		
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteLead(@RequestParam Integer leadId) {
		res=new Response();
		if(leadId==null) {
			
			return ResponseEntity.badRequest().body(res);
		}
		leadServices.deleteLead(leadId);
		res.setStatus(HttpStatus.OK);
		return ResponseEntity.ok().body(res);
		
	}
	@PutMapping("/update/{leadId}")
	public ResponseEntity<Response> updateLead(@RequestBody Lead lead, @PathVariable(name="leadId") int leadid) {
		 l =leadServices.getLead(leadid);
		 res=new Response();
		 
		  if(l!=null) {
			  leadServices.updateLead(lead);
			  return ResponseEntity.ok().body(res);
		  }
		return ResponseEntity.ok().body(res);
	}

}
