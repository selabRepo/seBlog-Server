package com.se.seblog.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.se.seblog.user.model.entity.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Long>{
	
	@Query("SELECT u FROM UserDto u WHERE u.email = :email")
	Optional<UserDto> findByEmail(String email);
}
