package com.learner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 private static Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	log.info("in memory authentication");
    	auth
          .inMemoryAuthentication()
          .withUser("guru")
          .password(passwordEncoder().encode("password"))
          .roles("USER")
          .and()
          .withUser("admin")
          .password(passwordEncoder().encode("admin"))
          .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/test/**");
        super.configure(http);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
    	return new BCryptPasswordEncoder();
    }
}