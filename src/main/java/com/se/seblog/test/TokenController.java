package com.se.seblog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.seblog.security.JwtTokenGenerator;
import com.se.seblog.security.model.JwtUser;

@RestController
@RequestMapping("/token")
public class TokenController {

	private JwtTokenGenerator jwtTokenGenerator;
	
	@Autowired
	public TokenController(JwtTokenGenerator jwtTokenGenerator) {
		this.jwtTokenGenerator = jwtTokenGenerator;
	}
	
	
	@PostMapping
	public String generate(@RequestBody JwtUser jwtUser) {
		JwtTokenGenerator jwtGenerator = new JwtTokenGenerator();
		return jwtGenerator.generate(jwtUser);
	}
	
}
