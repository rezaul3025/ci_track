package com.ci.track.web.event;

public class Prescription {
	
	private String description;
	
	private String dose;
	
	private String othersDose;
	
	public Prescription(){
		
	}
	
	public Prescription(String description, String dose, String othersDose){
		this.description = description;
		this.dose = dose;
		this.othersDose =  othersDose;
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

	@Override
	public String toString(){
		return this.description+" "+this.dose;
	}
	
}
