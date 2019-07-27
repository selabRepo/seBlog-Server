package com.se.seblog.security;

import org.springframework.stereotype.Component;

import com.se.seblog.security.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private String key = "stb_tech";
	
	public JwtUser validate(String token) {
		
		JwtUser jwtUser = null;
		try {
			
		Claims body = Jwts.parser().setSigningKey(key)
				.parseClaimsJws(token)
				.getBody();
		
		jwtUser = new JwtUser();
		jwtUser.setUserName(body.getSubject());
		jwtUser.setId(Long.parseLong((String)body.get("userId")));
		jwtUser.setRole((String)body.get("role"));
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return jwtUser;
	}

}
