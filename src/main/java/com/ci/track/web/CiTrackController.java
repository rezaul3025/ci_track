package com.ci.track.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="/patient/view/{id}")
	public String moveViewPatientPage(@PathVariable("id") Integer id, Model model){
		model.addAttribute("id", id);
		return "/patient/view";
	}
	
	@RequestMapping(value="/patient/list")
	public String moveListPatientPage(@RequestParam("idf") String idf, Model model){
		model.addAttribute("idf", idf);
		return "/patient/list";
	}
	
	@RequestMapping(value="/prescription/add/{id}")
	public String moveAddPrescriptionPage(@PathVariable("id") Integer id, Model model){
		model.addAttribute("id", id);
		return "/prescription/add";
	}
	
	@RequestMapping(value="/user/add")
	public String moveAddUserPage(Model model){
		return "/user/add";
	}
}
