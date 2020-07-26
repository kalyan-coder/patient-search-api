package com.patient.service;

import com.patient.domain.PatientDetailsByIdResponse;
import com.patient.domain.PatientDetailsResponse;

public interface PatientSeachService {

	public PatientDetailsByIdResponse patientDetailsById(String patientId);

	public PatientDetailsResponse patientDetails();

}
