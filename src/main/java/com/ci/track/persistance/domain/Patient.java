package com.ci.track.persistance.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Entity(name="patient")
@Document(collection = "patient")
public class Patient {
	
	@Id
    //@Column(name="id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	//@Column(name="first_name")
	private String firstName;
	
	//@Column(name="last_name")
	private String lastName;
	
	//@Column(name="date")
    @JsonFormat(pattern="yyyy-MM-dd" ,locale="de", timezone="GMT+1")
	private Date dob;
	
	private String age;
	
	private String address;
	
	private String gender;
	
	private Float height;
	
	private Float weight;
	
	public Patient(){
		
	}
	
	public Patient(String firstName, String lastName, Date dob, String address){
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	@Override
	public String toString(){
		return this.firstName+" "+this.lastName+" "+this.dob+" "+this.address;
	}
}
