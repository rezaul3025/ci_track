package com.ci.track.config.security.auth;


import org.springframework.security.core.authority.AuthorityUtils;

import com.ci.track.persistance.domain.User;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = 1;
	private User user;

	public CurrentUser(User user) {
		super(user.getUserName(), user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole()));
		// String total =
		// user.getRoles().stream().map(Role::getRole).collect(Collectors.joining(","));
		// System.out.println(total);
		this.user = user;
		
	}

	public User getUser() {
		return this.user;
	}

	public Integer getId() {
		return this.user.getId();
	}
	
	

}
