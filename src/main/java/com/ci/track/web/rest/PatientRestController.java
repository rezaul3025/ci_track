package com.ci.track.web.rest;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.track.web.event.PatientInfo;

@RestController
@RequestMapping(value="/rest/patient")
public class PatientRestController {
	
	@RequestMapping("/info")
	public PatientInfo getPatientInfo(){
		return new PatientInfo("Tom","Mia",new Date(), "Tom put");
	}
}
