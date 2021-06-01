package com.capgemini.healthcareproject.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "user_info")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "userId", unique = true)
	private int userId;
	
	@Column(name = "userPassword")
	private String userPassword;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "contactNo")
	private String contactNo;
	
	@Column(name = "userEmail")
	private String userEmail;
	
	@Column(name = "userRole")
	private String userRole;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "age")
	private int age;
	
	

}
