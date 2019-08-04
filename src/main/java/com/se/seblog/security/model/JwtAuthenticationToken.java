package com.se.seblog.security.model;

/**
 * 로그인 후 JwtToken 반환 모
 * 
 * @author youngjun.jin
 */
public class JwtAuthenticationToken {

	/** token */
	private String token;

	/** token type */
	private String tokenType;

	/** userID(user table id) */
	private long userID;

	/** user ID(email) */
	private String email;

	public JwtAuthenticationToken(String token, String tokenType, long userID, String email) {
		super();
		this.token = token;
		this.tokenType = tokenType;
		this.userID = userID;
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
