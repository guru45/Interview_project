package com.learner.repository;

import org.springframework.data.repository.CrudRepository;

import com.learner.entity.CourseEntity;

public interface LearnerRepository extends CrudRepository<CourseEntity,Integer> {

}
