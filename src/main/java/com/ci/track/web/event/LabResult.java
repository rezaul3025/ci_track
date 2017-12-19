package com.ci.track.web.event;

public class LabResult {
	
	private String description;
	
	private String result;
	
	private String referenceValue;
	
	public LabResult(){
		
	}
	
	public LabResult(String description, String result, String referenceValue){
		this.description = description;
		this.result = result;
		this.referenceValue = referenceValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getReferenceValue() {
		return referenceValue;
	}

	public void setReferenceValue(String referenceValue) {
		this.referenceValue = referenceValue;
	}
	
	@Override
	public String toString(){
		return this.description+" "+this.referenceValue+" "+this.result;
	}

}
