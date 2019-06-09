package com.se.seblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
	"com.se.seblog"
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
