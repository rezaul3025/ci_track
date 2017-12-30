package com.ci.track.persistance.service;

import com.ci.track.persistance.domain.User;
import com.ci.track.web.event.UserInfo;


public interface UserService {
	User add(UserInfo userInfo);
	User findByUserName(String userName);
}
