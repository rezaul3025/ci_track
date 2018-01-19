package com.ci.track.web.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ci.track.web.event.Prescription;

@RestController
@RequestMapping(value="/rest/prescription")
public class PrescriptionRestController {
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Prescription add(@RequestBody Prescription prescriptionInfoatientInfo){
		return prescriptionInfoatientInfo;
	}
}
