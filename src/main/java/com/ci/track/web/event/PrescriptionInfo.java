package com.ci.track.web.event;

import java.util.Date;
import java.util.List;

public class PrescriptionInfo {
	
	private String id;
	
	private String doctorId;
	
	private String comments;
	
	private String patientId;
	
	private List<PrescriptionItemInfo> prescriptionItem;
	
	private Date date;
	
	private Date modifiedDate;
	
	private String modifiedById;
	
	public PrescriptionInfo(){
		
	}
	
	public PrescriptionInfo(List<PrescriptionItemInfo> prescriptionItem, Date date, String doctorId, String patientId, String comments){
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

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
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

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedById() {
		return modifiedById;
	}

	public void setModifiedById(String modifiedById) {
		this.modifiedById = modifiedById;
	}
	
	
}
