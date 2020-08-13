package com.course.training.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="courseDet")
@Entity
public class CourseEntity {
	
	@Id
    @Column(name = "courseid")
	private Integer courseId;
	
	@Column(name="mentor_id")
	private String mentor;
	
	@Column(name="tech_name")
	private String techName;
	
	
}