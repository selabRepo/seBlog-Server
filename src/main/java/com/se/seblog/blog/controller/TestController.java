package com.se.seblog.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.seblog.blog.entity.Test;
import com.se.seblog.blog.service.TestService;

@RestController
public class TestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/test")
	public String test() {
		
		LOGGER.info("testestsetste");
		Test findById = this.testService.findById(1);
		return findById.getName();
	}
}
