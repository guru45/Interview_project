package com.course.training.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.course.training.entity.CourseEntity;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity,Integer> {

}
