package com.learner.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.learner.entity.CourseEntity;


@Service
public class LearnerService {
	
	
	 public LearnerService(RestTemplateBuilder restTemplateBuilder) {
	        this.restTemplate = restTemplateBuilder
	                .basicAuthentication("guru", "password")
	                .build();
	    }
	
	static final String courseDet1 = "http://localhost:8083/det/course";
	static final String courseDet2 = "http://localhost:8083/det/course/{id}";
	@Autowired
	 private RestTemplate restTemplate;
	
	
	 private static Logger LOGGER = LoggerFactory.getLogger(LearnerService.class);
	
	
	 @Async("asyncExecutor")
	    public CompletableFuture<List<CourseEntity>> getCourse() throws InterruptedException 
	    {
		 LOGGER.info("Thread 1");
		 ResponseEntity<List<CourseEntity>> rateResponse =
		 restTemplate.exchange(courseDet1,HttpMethod.GET, null, new ParameterizedTypeReference<List<CourseEntity>>() {
			            });
			List<CourseEntity> courses = rateResponse.getBody();
	        Thread.sleep(1000L);    //Intentional delay  
	        LOGGER.info(courses.toString());
	        return  CompletableFuture.completedFuture(courses);
	    }
	
	 
	 	@Async("asyncExecutor")
	    public CompletableFuture<CourseEntity> getCourseById() throws InterruptedException 
	    {
	 		LOGGER.info("Thread 2");
	        CourseEntity courseById =    restTemplate.getForObject(courseDet2,CourseEntity.class,11);  
	        Thread.sleep(1000L);    //Intentional delay  
	        LOGGER.info(courseById.toString());
	        return  CompletableFuture.completedFuture(courseById);
	    }
	 
	 
}
