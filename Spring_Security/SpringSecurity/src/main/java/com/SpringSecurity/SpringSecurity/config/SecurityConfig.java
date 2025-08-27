package com.SpringSecurity.SpringSecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//Override the default credentials given by spring secirity
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	public UserDetailsService userDetailsService() {
		var userDetails = new InMemoryUserDetailsManager();
		var user = User.withUsername("test").password("1234").authorities("read").roles("USER").build();
		userDetails.createUser(user);
		return userDetails;
	}

}
