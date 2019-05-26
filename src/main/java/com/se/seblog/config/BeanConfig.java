package com.se.seblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
	"com.se.seblog.blog",
	"com.se.seblog.user",
})
public class BeanConfig {
	
	/**
	 * ControllerConfig 클래스의 새 인스턴스를 추가합니다. 
	 * 
	 * @author youngjun.jin
	 */
	public BeanConfig() {
		super();
	}
	
}
