package com.course.training.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.course.training.entity.CourseEntity;
import com.course.training.service.CourseService;

@RestController
@RequestMapping("/det")
public class CourseController {
@Autowired
private CourseService course;
private static Logger log = LoggerFactory.getLogger(CourseController.class);

	
	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public List<CourseEntity> getCourse() {
	log.info("getCourse() invoked");
	return course.getCourse();
	}
	
	@RequestMapping("/course/{id}")
	public CourseEntity getCourseDetails(@PathVariable Integer id) {
		log.info("getCourseById() invoked");
		return course.getCourseDetails(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addCourse")
	public void addCourse(@RequestBody CourseEntity cd) {
		log.info("addCourse() invoked");
		course.addCourse(cd);
		
	}
	@RequestMapping(method=RequestMethod.PUT,value="/updateCourse/{id}")
	public void updateCourse(@RequestBody CourseEntity cd, @PathVariable Integer id) {
		log.info("updateCourse() invoked");
		course.updateCourse(cd, id);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteCourse/{id}")
	public void deleteCourse(@RequestBody CourseEntity cd, @PathVariable Integer id) {
		log.info("deleteCourse() invoked");
		course.deleteCourse(cd,id);
	}

}
