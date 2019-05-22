package com.se.seblog.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.seblog.blog.entity.Test;
import com.se.seblog.blog.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestRepository testRepository;
	
	
	@Override
	public Test findById(long id) {
		Optional<Test> findById = this.testRepository.findById(id);
		return findById.get();
	}

}
