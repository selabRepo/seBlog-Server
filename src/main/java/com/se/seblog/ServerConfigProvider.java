package com.se.seblog;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.se.seblog.config.BeanConfig;
import com.se.seblog.config.DataSourceConfig;
import com.se.seblog.config.SecurityConfig;

@Configuration
@Import({
	BeanConfig.class,
	DataSourceConfig.class,
	SecurityConfig.class,
})
public class ServerConfigProvider {

	/**
	 * ServerConfigProvider 클래스의 새 인스턴스를 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 */
	public ServerConfigProvider() {
		super();
	}
}
