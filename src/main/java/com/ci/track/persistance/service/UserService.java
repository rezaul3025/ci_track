package com.ci.track.persistance.service;

import com.ci.track.persistance.domain.User;


public interface UserService {
	User findByUserName(String userName);
}
