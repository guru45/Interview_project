package com.course.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;



@SpringBootApplication
@EnableWebSecurity
@EntityScan(basePackages = { "com.course.training.entity" })
@EnableEurekaClient

public class TrainingCourseApplication {
	
	 private static Logger LOGGER = LoggerFactory.getLogger(TrainingCourseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TrainingCourseApplication.class, args);
		LOGGER.info("Course App started");
	
	}

}
