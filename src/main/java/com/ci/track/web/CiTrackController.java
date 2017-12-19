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
}
