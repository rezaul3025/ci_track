package com.ci.track.persistance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.track.persistance.domain.User;
import com.ci.track.persistance.repo.UserRepository;

@Service
public class UserServiceHandler implements UserService {
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

}
