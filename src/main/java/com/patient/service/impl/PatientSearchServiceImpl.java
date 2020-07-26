package com.patient.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.patient.Exception.PatientSearchException;
import com.patient.domain.Patient;
import com.patient.domain.PatientDetailsByIdResponse;
import com.patient.domain.PatientDetailsResponse;
import com.patient.repository.PatientRepository;
import com.patient.service.PatientSeachService;

@Service
public class PatientSearchServiceImpl implements PatientSeachService {

	@Autowired
	PatientRepository patientRepo;

	@Autowired
	PatientDetailsByIdResponse patientDetailsByIdResponse;

	@Autowired
	PatientDetailsResponse patientDetailsResponse;

	@Override
	public PatientDetailsByIdResponse patientDetailsById(String patientId) {
		try {
			Optional<Patient> patient = patientRepo.getPatientDetailsById(patientId);
			if (patient.isPresent()) {
				patientDetailsByIdResponse.setPatient(patient.get());
				patientDetailsByIdResponse.setStatusMessage("Patient Details Found for ID" + patientId);
			} else {
				patientDetailsByIdResponse.setStatusMessage("Patient Details Not Found for ID" + patientId);
			}
			return patientDetailsByIdResponse;
		} catch (Exception ex) {
			throw new PatientSearchException("Internal Server Error While getting patientDetailsById");
		}
	}

	@Override
	public PatientDetailsResponse patientDetails() {
		try {
			if (CollectionUtils.isEmpty(patientRepo.getPatientDetails())) {
				patientDetailsResponse.setStatusMessage("Patient Details Not Found for ID");
			} else {
				patientDetailsResponse.setStatusMessage("Patient Details Found");
				patientDetailsResponse.setPatientDetails(patientRepo.getPatientDetails());
			}
			return patientDetailsResponse;
		} catch (Exception ex) {
			throw new PatientSearchException("Internal Server Error While getting patientDetails");
		}
	}

}
