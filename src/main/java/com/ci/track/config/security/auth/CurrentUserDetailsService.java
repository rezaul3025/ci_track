package com.ci.track.config.security.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ci.track.persistance.domain.User;
import com.ci.track.persistance.service.UserService;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.findByUserName(username);
        if(user == null){
        	throw new UsernameNotFoundException("Unable to load user by username = '" + username + "'");
        }
        return new CurrentUser(user);
    }
}
