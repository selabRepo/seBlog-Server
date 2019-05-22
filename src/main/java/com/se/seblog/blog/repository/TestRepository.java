package com.se.seblog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.seblog.blog.entity.Test;

@Deprecated
public interface TestRepository extends JpaRepository<Test, Long>{

	
	
}
