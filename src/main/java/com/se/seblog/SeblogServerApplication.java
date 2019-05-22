package com.se.seblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
	ServerConfigProvider.class	
})
public class SeblogServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeblogServerApplication.class, args);
	}
}
