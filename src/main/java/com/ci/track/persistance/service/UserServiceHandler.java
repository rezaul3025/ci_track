package com.ci.track.persistance.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ci.track.persistance.domain.User;
import com.ci.track.persistance.repo.UserRepository;
import com.ci.track.web.event.UserInfo;

@Service
public class UserServiceHandler implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUserName(userName);
		return user;
	}

	@Override
	public User add(UserInfo userInfo) {
		User user = new User();
		BeanUtils.copyProperties(userInfo, user);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setRole(user.getDesignation()!=null && user.getDesignation().equals("Doctor")?"DOCTOR":"OTHERS");
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> findByIds(List<String> ids) {
		List<User> users = userRepository.findByIdIn(ids);
		return users;
	}

}
