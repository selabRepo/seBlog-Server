package com.se.seblog.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.seblog.user.model.entity.UserDto;
import com.se.seblog.user.repository.UserRepository;

/**
 * 회원 관리 컨트롤러
 * 
 * @author youngjun.jin
 */
@RestController
@RequestMapping("/api")
public class UserController {

	/** user repository */
	@Autowired
	private UserRepository userRepository;

	/** password encoder */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * 회원 정보로 회원가입을 수해합니다.
	 * 
	 * @param user user 정보
	 * @return success
	 */
	@PostMapping("/signup")
	public String insertUser(@RequestBody UserDto user) {
		System.out.println("test");
		String password = user.getPassword();
		String encodedPassword = this.passwordEncoder.encode(password);
		user.setPassword(encodedPassword);

		this.userRepository.save(user);
		return "success";
	}
}
