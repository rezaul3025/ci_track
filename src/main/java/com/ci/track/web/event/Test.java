package com.ci.track.web.event;

public class Test<T> {
	
	private Integer id;
	
	private Integer patientId;
	
	private String description;
	
	private TestType testType;
	
	private T test;
	
	public Test(){
		
	}
	
	public Test(Integer patientId, String description, TestType testType, T test){
		this.patientId  = patientId;
		this.description = description;
		this.test = test;
		this.testType = testType;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
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

	public TestType getTestType() {
		return testType;
	}

	public void setTestType(TestType testType) {
		this.testType = testType;
	}

	public T getTest() {
		return test;
	}

	public void setTest(T test) {
		this.test = test;
	}
	
	@Override
	public String toString(){
		return this.patientId+" "+this.description+" "+this.testType+" "+this.test;
	}

}
