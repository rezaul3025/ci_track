package com.ci.track.web.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ci.track.web.event.PrescriptionInfo;

public class UserRestController {
	
	@RestController
	@RequestMapping(value="/rest/user")
	public class PrescriptionRestController {
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public PrescriptionInfo add(@RequestBody PrescriptionInfo prescriptionInfoatientInfo){
			return prescriptionInfoatientInfo;
		}
	}

}
