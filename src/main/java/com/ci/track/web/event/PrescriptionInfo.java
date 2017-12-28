package com.ci.track.web.event;

import java.util.Date;
import java.util.List;

public class PrescriptionInfo {
	
	private List<Prescription> prescription;
	
	private Date date;
	
	private Integer doctorId;
	
	private String comments;
	
	private Integer patientId;
	
	public PrescriptionInfo(){
		
	}
	
	public PrescriptionInfo(List<Prescription> prescription, Date date, Integer doctorId, Integer patientId, String comments){
		this.prescription = prescription;
		this.date = date;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.comments = comments;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	
}
