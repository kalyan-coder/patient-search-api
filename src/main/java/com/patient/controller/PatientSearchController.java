package com.patient.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.patient.service.PatientSeachService;

@RestController
public class PatientSearchController {

	@Autowired
	PatientSeachService patientSearchService;

	@GetMapping(value = "/patient/{patientId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> patientDetailsById(@Valid @PathVariable(value = "patientId") String patientId) {

		return ResponseEntity.status(HttpStatus.OK).body(patientSearchService.patientDetailsById(patientId));
	}

	@GetMapping(value = "/patient/patientDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> patientDetails() {
		return ResponseEntity.status(HttpStatus.OK).body(patientSearchService.patientDetails());
	}

}
