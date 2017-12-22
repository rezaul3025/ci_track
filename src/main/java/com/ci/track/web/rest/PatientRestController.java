package com.ci.track.web.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ci.track.web.event.LabResult;
import com.ci.track.web.event.LabTest;
import com.ci.track.web.event.PatientInfo;
import com.ci.track.web.event.PrescriptionInfo;
import com.ci.track.web.event.Test;

@RestController
@RequestMapping(value="/rest/patient")
public class PatientRestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/info")
	public PatientInfo getPatientInfo(){
		return new PatientInfo("Tom","Mia",new Date(), "Tom put");
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public PatientInfo addInfo(@RequestBody PatientInfo patientInfo){
		System.out.println(patientInfo);
		jdbcTemplate.execute("INSERT INTO patient VALUES(2,'sas','sasa','2017-02-02','ewee');");
		return patientInfo;
	}
	
	@RequestMapping(value="/add-prescription", method=RequestMethod.POST)
	public PrescriptionInfo addPrescription(@RequestBody PrescriptionInfo prescriptionInfo){
		
		System.out.println(prescriptionInfo);
		
		return prescriptionInfo;
	}
	
	@RequestMapping(value="/add-labresult", method=RequestMethod.POST)
	public List<LabResult> addLabResult(@RequestBody List<LabResult> labResult){
		System.out.println(labResult);
		
		return labResult;
	}
	
	@RequestMapping(value="/add-labtest", method=RequestMethod.POST)
	public Test<LabTest> addLabTest(@RequestBody Test<LabTest> labTest){
		
		System.out.println(labTest);
		
		return labTest;
	}
}
