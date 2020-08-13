package com.learner.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.learner.entity.CourseEntity;
import com.learner.service.LearnerService;


@RestController
@EnableEurekaClient
public class LearnerController {

	@Autowired
	LearnerService Ls;
	 private static Logger LOGGER = LoggerFactory.getLogger(LearnerController.class);

	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    public void testAsynch() throws InterruptedException, ExecutionException 
    {
       
		LOGGER.info("inside async task");
       CompletableFuture<List<CourseEntity>> coursedet = Ls.getCourse();
       CompletableFuture<CourseEntity> coursedet1 = Ls.getCourseById();
 
        // Wait until they are all done
       LOGGER.info("req1--> " + coursedet.toString());
       LOGGER.info("req2--> " + coursedet1.toString());
        CompletableFuture.allOf(coursedet,coursedet1).join();
         
       
    }
}
