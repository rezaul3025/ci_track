package com.ci.track.web.event;

import java.util.Date;
import java.util.List;

public class PrescriptionInfo {
	
	private List<Prescription> prescription;
	
	private Date date;
	
	private Integer doctorId;
	
	public PrescriptionInfo(){
		
	}
	
	public PrescriptionInfo(List<Prescription> prescription, Date date, Integer doctorId){
		this.prescription = prescription;
		this.date = date;
		this.doctorId = doctorId;
	}

	public List<Prescription> getPrescription() {
		return prescription;
	}

	public void setPrescription(List<Prescription> prescription) {
		this.prescription = prescription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	
	@Override
	public String toString(){
		return this.prescription+" "+this.date+" "+this.doctorId;
	}

}
