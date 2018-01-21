package com.ci.track.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ci.track.persistance.domain.Prescription;
import com.ci.track.persistance.service.PrescriptionService;
import com.ci.track.web.event.PrescriptionInfo;

@RestController
@RequestMapping(value="/rest/prescription")
public class PrescriptionRestController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public PrescriptionInfo add(@RequestBody PrescriptionInfo prescriptionInfoatientInfo){
		
		prescriptionService.addPrescription(prescriptionInfoatientInfo);
		return prescriptionInfoatientInfo;
	}
	
	@RequestMapping(value="/patient/{id}", method=RequestMethod.GET)
	public List<Prescription>  findByPatient(@PathVariable("id") String id){
		List<Prescription> prescriptions = prescriptionService.findByPatientId(id);
		return prescriptions;
	}
}
