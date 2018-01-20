package com.ci.track.persistance.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="prescription")
public class Prescription {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="doctor_id")
	private Integer doctorId;
	
	private String comments;
	
	@Column(name="patient_id")
	private Integer patientId;
	
	private Date date;
	
	@Column(name="modified_date")
	private Date modifiedDate;
	
	@Column(name="modified_by_id")
	private Integer modifiedById;
	
	@OneToMany(mappedBy = "prescription", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JsonManagedReference
	private List<PrescriptionItem> prescriptionItem;
	
	public Prescription(){
		
	}
	
	public Prescription(List<PrescriptionItem> prescriptionItem, Date date, Integer doctorId, Integer patientId, String comments){
		this.prescriptionItem = prescriptionItem;
		this.date = date;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getModifiedById() {
		return modifiedById;
	}

	public void setModifiedById(Integer modifiedById) {
		this.modifiedById = modifiedById;
	}
	
}
