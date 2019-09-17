package com.devshop.devshop.service;

import com.devshop.devshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionUserProvider {
	@Autowired
	private UserDetailsService userDetailsService;
	private User user;

	public User getLoggedUser() {
		return user;
	}

	@Transactional
	public void saveLoggedUser(String username) {
		user = (User) userDetailsService.loadUserByUsername(username);

	}
}
