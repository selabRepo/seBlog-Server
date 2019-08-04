package com.se.seblog.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * JWT 토큰 검증 인스턴스
 * 
 * @author youngjun.jin
 */
@Component
public class JwtTokenValidator {

	/** slf4j logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenValidator.class);

	/**  토큰 암호화 값 */
	private String jwtSecret = "stb-test";

	/**
	 * 요받은 토큰이 유효한지 검사한다.
	 * 
	 * @param authToken jwtToken
	 * @return 토큰 유효성 여부
	 */
	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
			LOGGER.error("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			LOGGER.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			LOGGER.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			LOGGER.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			LOGGER.error("JWT claims string is empty.");
		}
		return false;
	}

}
