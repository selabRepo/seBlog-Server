package com.se.seblog.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.se.seblog.security.model.JwtUserDetails;
import com.se.seblog.user.model.entity.UserDto;
import com.se.seblog.user.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = this.userRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("입력한 아이디에 해당하는 User를 찾을 수 없습니다."));

		
		return JwtUserDetails.create(userDto);
	}
	
	public UserDetails loadUserById(Long id) {
        UserDto userDto = userRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return JwtUserDetails.create(userDto);
    }

}
