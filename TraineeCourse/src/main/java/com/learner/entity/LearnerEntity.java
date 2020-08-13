package com.learner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdetails")
public class LearnerEntity {

	@Id
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="username")
	private String username;
	
	
	public LearnerEntity(){
		
	}
	
	public LearnerEntity(Integer userid,String userName) {
		this.userId = userid;
		
		this.username=userName;
	}
	public String getuserName() {
		return username;
	}
	public void setuserName(String userName) {
		this.username = userName;
	}

	public Integer getuserId() {
		return userId;
	}
}