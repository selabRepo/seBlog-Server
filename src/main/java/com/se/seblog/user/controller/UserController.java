package com.se.seblog.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.seblog.user.entity.UserVo;
import com.se.seblog.user.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@PostMapping("/user")
	public String insertUser(@RequestBody UserVo user) {
		System.out.println("test");
		String password = user.getPassword();
		String encode = this.bCryptPasswordEncoder.encode(password);
		user.setPassword(encode);
		
		this.userRepository.save(user);
		return "success";
	}
}
