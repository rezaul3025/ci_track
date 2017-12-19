package com.ci.track.web.event;

import java.util.List;

public class LabTest {
	private Integer id;
	
	private String description;
	
	private List<LabResult> labResult;
	
	public LabTest(){
		
	}
	
	public LabTest(String description, List<LabResult> labResult){
		this.description = description;
		this.labResult = labResult;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<LabResult> getLabResult() {
		return labResult;
	}

	public void setLabResult(List<LabResult> labResult) {
		this.labResult = labResult;
	}
	
	@Override
	public String toString(){
		return this.description+" "+this.labResult;
	}

	
}
