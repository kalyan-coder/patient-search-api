package com.patient.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientSearchServiceImpl.class);

	@Autowired
	PatientRepository patientRepo;

	@Autowired
	PatientDetailsByIdResponse patientDetailsByIdResponse;

	@Autowired
	PatientDetailsResponse patientDetailsResponse;

	@Override
	public PatientDetailsByIdResponse patientDetailsById(String patientId) {
		LOGGER.info("Patient search with ID {}", patientId);
		try {
			Optional<Patient> patient = patientRepo.getPatientDetailsById(patientId);
			if (patient.isPresent()) {
				patientDetailsByIdResponse.setPatient(patient.get());
				patientDetailsByIdResponse.setStatusMessage("Patient Details Found for ID" + patientId);
				LOGGER.info("Successfully fetch the patient data for ID : {}", patientId);
			} else {
				LOGGER.info("No Data Found for Patient ID : {}", patientId);
				patientDetailsByIdResponse.setStatusMessage("Patient Details Not Found for ID" + patientId);
			}
			return patientDetailsByIdResponse;
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			throw new PatientSearchException("Internal Server Error While getting patientDetailsById");
		}
	}

	@Override
	public PatientDetailsResponse patientDetails() {
		LOGGER.info("Patient Details");
		try {
			if (CollectionUtils.isEmpty(patientRepo.getPatientDetails())) {
				patientDetailsResponse.setStatusMessage("Patient Details Not Found for ID");
				LOGGER.info("No Patient Details found in DB");
			} else {
				patientDetailsResponse.setStatusMessage("Patient Details Found");
				patientDetailsResponse.setPatientDetails(patientRepo.getPatientDetails());
				LOGGER.info("Successfully fetch the patient details");
			}
			return patientDetailsResponse;
		} catch (Exception ex) {
			throw new PatientSearchException("Internal Server Error While getting patientDetails");
		}
	}

}
