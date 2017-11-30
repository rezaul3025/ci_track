package com.ci.track.web.event;

import java.util.Date;

public class PatientInfo {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Date dob;
	
	private String address;
	
	public PatientInfo(){
		
	}
	
	public PatientInfo(String firstName, String lastName, Date dob, String address){
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
