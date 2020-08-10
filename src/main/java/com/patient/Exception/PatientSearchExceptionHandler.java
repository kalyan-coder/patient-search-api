package com.patient.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PatientSearchExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(PatientSearchException.class)
	public ResponseEntity<Object> handlePatientSearchException(PatientSearchException ex) {
		ErrorResponse errorRes = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		return buildResponseEntity(errorRes);
	}

	@Override
	public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse errorRes = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
		return buildResponseEntity(errorRes);
	}

	private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
		return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
	}

}
