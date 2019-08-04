package com.se.seblog.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.seblog.security.JwtTokenProvider;
import com.se.seblog.security.model.JwtAuthenticationToken;
import com.se.seblog.user.model.entity.LoginUserModel;

/**
 * 계정 관련 컨트롤러
 * 
 * @author youngjun.jin
 */
@RestController
@RequestMapping("/api")
public class LoginController {

	/** 인증 매니저 */
	@Autowired
	private AuthenticationManager authenticationManager;

	/** jwt token 제공 인스턴스 */
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	/**
	 * 로그인 정보를 통해 로그인 후 토근값을 반환합니다.
	 * 
	 * @param loginUser 로그인 정보 모델
	 * @return 토큰 정보
	 */
	@PostMapping("/login")
	public ResponseEntity<JwtAuthenticationToken> login(@RequestBody LoginUserModel loginUser) {
		Authentication authentication = this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		JwtAuthenticationToken generatedToken = this.jwtTokenProvider.generateToken(authentication);
		return ResponseEntity.ok(generatedToken);
	}

	@PostMapping("/logout")
	public void logout() {
		throw new IllegalArgumentException("미구현");
	}
}
