package com.se.seblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
public class WebConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //TODO: 추후에 도메인 설정해줘야됨
                registry.addMapping("/api/**")
                        .allowedOrigins("*")
                        .allowCredentials(true)
                        .maxAge(3600);
            }
        };
    }
}