package com.example.myblog.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.myblog.data.UserRepository;
import com.example.myblog.entities.MyBlogUserDetails;
import com.example.myblog.entities.User;

public class MyBlogUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findUserByEmail(username);
		if(user.isPresent()) {
			return new MyBlogUserDetails(user.get());
		}
		throw new UsernameNotFoundException("Could not find user with that email");
	}

	
	
}
