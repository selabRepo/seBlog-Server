package com.se.seblog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.seblog.user.entity.UserVo;

public interface UserRepository extends JpaRepository<UserVo, Long>{
	
	UserVo findByEmail(String email);
}
