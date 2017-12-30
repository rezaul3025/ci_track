package com.ci.track.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CiTrackController {
	
	@RequestMapping(value="/")
	public String moveLoginPage(Model model){
		return "login";
	}
	
	@RequestMapping(value="/home")
	public String moveHomePage(Model model){
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
	
	@RequestMapping(value="/user/add")
	public String moveAddUserPage(Model model){
		return "/user/add";
	}
}
