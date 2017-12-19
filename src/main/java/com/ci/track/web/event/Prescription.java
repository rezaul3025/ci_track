package com.ci.track.web.event;

public class Prescription {
	
	private String description;
	
	private String dose;
	
	public Prescription(){
		
	}
	
	public Prescription(String description, String dose){
		this.description = description;
		this.dose = dose;
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
	
	@Override
	public String toString(){
		return this.description+" "+this.dose;
	}
	
}
