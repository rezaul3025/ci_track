package com.ci.track.persistance.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Entity(name="prescription")
@Document(collection = "prescription")
public class Prescription {
	
	@Id
	//@Column(name="id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	//@Column(name="doctor_id")
	private String doctorId;
	
	private String comments;
	
	//@Column(name="patient_id")
	private String patientId;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm" ,locale="de", timezone="GMT+1")
	private Date date;
	
	private String prescriptionPdfId;
	
	//@Column(name="modified_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm" ,locale="de", timezone="GMT+1")
	private Date modifiedDate;
	
	//@Column(name="modified_by_id")
	private String modifiedById;
	
	//@OneToMany(mappedBy = "prescription", fetch=FetchType.EAGER,  cascade=CascadeType.ALL)
    //@JsonManagedReference
	private List<PrescriptionItem> prescriptionItem;
	
	public Prescription(){
		
	}
	
	public Prescription(List<PrescriptionItem> prescriptionItem, Date date, String doctorId, String patientId, String comments){
		this.prescriptionItem = prescriptionItem;
		this.date = date;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.comments = comments;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<PrescriptionItem> getPrescriptionItem() {
		return prescriptionItem;
	}

	public void setPrescriptionItem(List<PrescriptionItem> prescriptionItem) {
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
	
	public String getPrescriptionPdfId() {
		return prescriptionPdfId;
	}

	public void setPrescriptionPdfId(String prescriptionPdfId) {
		this.prescriptionPdfId = prescriptionPdfId;
	}

	@Override
	public String toString(){
		return this.prescriptionItem+" "+this.date+" "+this.doctorId;
	}
	
}
