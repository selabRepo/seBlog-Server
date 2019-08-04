package com.se.seblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.se.seblog.security.JwtAuthenticationEntryPoint;
import com.se.seblog.security.JwtAuthenticationFilter;
import com.se.seblog.user.service.CustomUserDetailsService;

/**
 * security configuration 클래스
 *
 * @author youngjun.jin
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/** 사용자 이름에 대한 SecurityUser 매핑을 지원하는 서비스 */
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;

	/**
	 * BCryptPasswordEncoder Bean 등록
	 * 
	 * @return bCryptPasswordEncoder
	 */
	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationTokenFilter() {
		return new JwtAuthenticationFilter();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			
			.exceptionHandling().authenticationEntryPoint(this.entryPoint)
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers("/api/login","/api/signup").permitAll()
			.anyRequest().authenticated();

		http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		http.headers().cacheControl();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(customUserDetailsService)
				.passwordEncoder(this.bCryptPasswordEncoder());
	}

}
