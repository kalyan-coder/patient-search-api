package com.patient.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PatientDetailsResponse {

	List<Patient> patientDetails = new ArrayList<>();

	String statusMessage;

	public List<Patient> getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(List<Patient> patientDetails) {
		this.patientDetails = patientDetails;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
