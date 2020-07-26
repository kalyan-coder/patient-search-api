package com.patient.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.patient.data.PatientDataStore;
import com.patient.domain.Patient;

@Repository
public class PatientRepository {

	public Optional<Patient> getPatientDetailsById(String patinetId) {

		return PatientDataStore.getAllPatients().stream()
				.filter(patient -> patient.getPatinetId().equalsIgnoreCase(patinetId)).findFirst();

	}

	public List<Patient> getPatientDetails() {
		return PatientDataStore.getAllPatients();
	}

}
