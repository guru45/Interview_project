package com.learner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableEurekaClient
@EnableWebSecurity
public class TraineeCourseApplication {

	 private static Logger log = LoggerFactory.getLogger(TraineeCourseApplication.class);

	public static void main(String[] args) {
	
		SpringApplication.run(TraineeCourseApplication.class, args);
		log.info("Learner App Started");
	}
	
	@SuppressWarnings("deprecation")
	@Bean
    public RestTemplate restTemplate() {
		RestTemplate restTemplate= new RestTemplate();
	
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("guru", "password"));
        return restTemplate;
    }
	
	
 
}
