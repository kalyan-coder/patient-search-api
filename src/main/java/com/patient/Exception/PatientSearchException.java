package com.patient.Exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PatientSearchException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PatientSearchException(String message) {
		super(message);
	}

}
