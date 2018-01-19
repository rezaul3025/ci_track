package com.ci.track.web.event;

import java.util.Date;
import java.util.List;

public class PrescriptionInfo {
	
	private Date date;
	
	private Integer doctorId;
	
	private String comments;
	
	private Integer patientId;
	
	private List<PrescriptionItemInfo> prescriptionItem;
	
	public PrescriptionInfo(){
		
	}
	
	public PrescriptionInfo(List<PrescriptionItemInfo> prescriptionItem, Date date, Integer doctorId, Integer patientId, String comments){
		this.prescriptionItem = prescriptionItem;
		this.date = date;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.comments = comments;
	}

	public List<PrescriptionItemInfo> getPrescriptionItem() {
		return prescriptionItem;
	}

	public void setPrescriptionItem(List<PrescriptionItemInfo> prescriptionItem) {
		this.prescriptionItem = prescriptionItem;
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
		return this.prescriptionItem+" "+this.date+" "+this.doctorId;
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
