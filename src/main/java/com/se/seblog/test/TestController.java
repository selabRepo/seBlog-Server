package com.se.seblog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class TestController {
	
	@GetMapping
	public String getHello() {
		return "hello";
	}
}
