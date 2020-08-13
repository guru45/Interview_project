package com.course.training.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.training.entity.CourseEntity;
import com.course.training.repository.CourseRepository;



@Service
public class CourseService {
	
	 private static Logger log = LoggerFactory.getLogger(CourseService.class);
	@Autowired
	private CourseRepository repo;
	
	public List<CourseEntity> getCourse() {
		List<CourseEntity> list=new ArrayList<>();
		repo.findAll().forEach(list::add);
	
		return list;
	}
	
	public CourseEntity getCourseDetails(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public void addCourse(CourseEntity cd) {
		repo.save(cd);
	}

	public void updateCourse(CourseEntity cd,Integer id) {
		repo.save(cd);
	}

	public void deleteCourse(CourseEntity cd, Integer id) {
		
		repo.delete(cd);
	}
	

}
