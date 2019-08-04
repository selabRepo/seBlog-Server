package com.se.seblog.user.model.entity;

/**
 * 사용자 로그인 모델
 * 
 * @author youngjun.jin
 */
public class LoginUserModel {

	/** 사용자 아이디 */
	private String userName;

	/** 사용자 패스워드 */
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
