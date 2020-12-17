package com.fernsnpetals.Sample.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Response {
	
	private HttpStatus status;
	private String reason;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus badRequest) {
		this.status = badRequest;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

}
