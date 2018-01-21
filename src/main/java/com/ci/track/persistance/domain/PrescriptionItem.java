package com.ci.track.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;

//@Entity(name="prescription_item")
public class PrescriptionItem {
	
	@Id
	//@Column(name="id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	private String description;
	
	private String dose;
	
	//@Column(name="others_dose")
	private String othersDose;
	
	//@ManyToOne
    //@JsonBackReference
    //@JoinColumn(name = "prescription_id", referencedColumnName = "id")
	private Prescription prescription;
	
	public PrescriptionItem(){
		
	}
	
	public PrescriptionItem(String description, String dose, String othersDose){
		this.description = description;
		this.dose = dose;
		this.othersDose =  othersDose;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}
	
	public String getOthersDose() {
		return othersDose;
	}

	public void setOthersDose(String othersDose) {
		this.othersDose = othersDose;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString(){
		return this.description+" "+this.dose;
	}
}
