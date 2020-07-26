package com.patient.domain;

public class Patient {

	private String firstName;
	private String lastName;
	private String dob;
	private String patinetId;
	private String address;

	public Patient(String firstName, String lastName, String dob, String patinetId, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.patinetId = patinetId;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPatinetId() {
		return patinetId;
	}

	public void setPatinetId(String patinetId) {
		this.patinetId = patinetId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
