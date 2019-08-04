package com.se.seblog.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.se.seblog.security.model.JwtAuthenticationToken;
import com.se.seblog.security.model.JwtUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * jwtToken 제공 인스턴스 
 * 
 * @author youngjun.jin
 */
@Component
public class JwtTokenProvider {

	/**  토큰 암호화 값 */
	private String jwtSecret = "stb-test";
	
	/**  토큰 만료일 */
	private int jwtExpiration = 1000*60*6*24;
	
	/**
	 * 토큰을 생성합니다. 
	 * @param authentication 인증 정보
	 * @return jwtToken 모델
	 */
	public JwtAuthenticationToken generateToken(Authentication authentication) {
		
		JwtUserDetails jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();

        Date expiryDate = new Date(System.currentTimeMillis() + this.jwtExpiration);
        String email = jwtUserDetails.getUsername();
        Long id = jwtUserDetails.getId();

        String token = Jwts.builder()
		.setSubject(Long.toString(jwtUserDetails.getId()))
		.setIssuedAt(new Date())
		.setExpiration(expiryDate)
		.signWith(SignatureAlgorithm.HS512, jwtSecret)
		.compact();
        
        return new JwtAuthenticationToken(token, "Bearer", id, email);
	}
	
	/**
	 * 토큰으로 부터 userID를 반환합니다.
	 * @param token jwtToken
	 * @return userID
	 */
	public Long getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

}
