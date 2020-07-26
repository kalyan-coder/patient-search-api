package com.patient.Exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private HttpStatus status;
	private String developerText;

	public ErrorResponse(HttpStatus status, String developerText) {
		super();
		this.status = status;
		this.developerText = developerText;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getDeveloperText() {
		return developerText;
	}

	public void setDeveloperText(String developerText) {
		this.developerText = developerText;
	}

}
