package com.ci.track.persistance.service;

import java.util.List;

import com.ci.track.persistance.domain.User;
import com.ci.track.web.event.UserInfo;


public interface UserService {
	
	User add(UserInfo userInfo);
	
	User findByUserName(String userName);
	
	User findById(String id);
	
	List<User> findByIds(List<String> ids);
}
