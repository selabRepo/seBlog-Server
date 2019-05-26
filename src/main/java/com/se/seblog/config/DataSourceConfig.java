package com.se.seblog.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:datasource.properties")
@EntityScan(value = {"com.se.seblog.blog.entity"})
@EnableJpaRepositories(basePackages = {"com.se.seblog.blog.repository"})
@EnableTransactionManagement
public class DataSourceConfig {

	/**
	 * dataSourceConfig를 초기화 합니다.
	 */
	public DataSourceConfig() {
		super();
	}
	
	/**
	 * DataSource bean 등록
	 * 
	 * @author "youngjun.jin"
	 * @return dataSource
	 */
	@Bean
	@ConfigurationProperties("seblog.datasource")
	public DataSource dataSource() {

		return new DriverManagerDataSource();
	}

}
