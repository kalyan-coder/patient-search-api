package com.patient.domain;

import org.springframework.stereotype.Component;

@Component
public class PatientDetailsByIdResponse {

	Patient patient;

	String statusMessage;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
