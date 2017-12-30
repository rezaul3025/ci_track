package com.ci.track.web.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ci.track.web.event.UserInfo;

public class UserRestController {
	
	@RestController
	@RequestMapping(value="/rest/user")
	public class PrescriptionRestController {
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public UserInfo add(@RequestBody UserInfo userInfo){
			return userInfo;
		}
	}

}
