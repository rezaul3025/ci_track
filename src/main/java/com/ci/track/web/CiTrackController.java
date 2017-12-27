package com.ci.track.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CiTrackController {
	
	@RequestMapping(value="/")
	public String moveLandingPage(Model model){
		return "index";
	}
	
	@RequestMapping(value="/patient/add")
	public String moveAddPatientPage(Model model){
		return "/patient/add";
	}
	
	@RequestMapping(value="/prescription/add")
	public String moveAddPrescriptionPage(Model model){
		return "/prescription/add";
	}
}
