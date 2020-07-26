package com.patient.data;

import java.util.Arrays;
import java.util.List;

import com.patient.domain.Patient;

public class PatientDataStore {

	/**
	 * Patient data store , ideally gets from DB.
	 * 
	 * @return
	 */
	public static List<Patient> getAllPatients() {

		Patient p1 = new Patient("Adam", "Smith", "11/01/2017", "1000", "123 Strings Ave");
		Patient p2 = new Patient("Brian", "Jones", "8/01/1990", "2000", "436 widgeon dr");
		Patient p3 = new Patient("Charlie", "Chris", "3/01/1983", "3000", "1213 highland Ave");
		Patient p4 = new Patient("Donald", "Doo", "6/01/1987", "4000", "345 prince Ave");
		Patient p5 = new Patient("Eric", "Greg", "8/01/1991", "5000", "789 hi Ave");
		Patient p6 = new Patient("Frank", "Herald", "7/01/2018", "6000", "87899 smith Ave");

		List<Patient> Patients = Arrays.asList(p1, p2, p3, p4, p5, p6);
		return Patients;
	}

}
