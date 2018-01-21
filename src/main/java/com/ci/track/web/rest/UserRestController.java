package com.ci.track.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ci.track.persistance.domain.User;
import com.ci.track.persistance.service.UserService;
import com.ci.track.web.event.UserInfo;

@RestController
@RequestMapping(value="/rest/user")
public class UserRestController {
	
	@Autowired
    private UserService userService;

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public User add(@RequestBody UserInfo userInfo){
		
		return userService.add(userInfo);
	}
	
	@RequestMapping(value="/find_by_ids", method=RequestMethod.POST)
	public List<User> findUsersByIds(@RequestBody List<String> ids){
		
		return userService.findByIds(ids);
	}
}
