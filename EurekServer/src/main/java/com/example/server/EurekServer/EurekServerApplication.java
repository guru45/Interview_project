package com.example.server.EurekServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableEurekaServer
@EnableWebSecurity
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class EurekServerApplication {


	private static Logger log = LoggerFactory.getLogger(EurekServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EurekServerApplication.class, args);
		log.info("Eureka Server Started");
	}

}
