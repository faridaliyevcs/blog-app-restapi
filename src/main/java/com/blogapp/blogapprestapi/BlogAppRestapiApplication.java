package com.blogapp.blogapprestapi;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.blogapp")
@EnableJpaRepositories(basePackages = "com.blogapp.repository")
@EntityScan(basePackages = "com.blogapp.entity")
@ComponentScan(basePackages = {"com.blogapp", "com.blogapp.security", "com.blogapp.service.impl", "com.blogapp.service.inter", "com.blogapp.payload"})
@RequiredArgsConstructor
public class BlogAppRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppRestapiApplication.class, args);
	}
}
