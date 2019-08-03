package com.se.seblog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.seblog.user.model.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Long>{
	
	UserDto findByEmail(String email);
}
