package com.capgemini.healthcareproject.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "test")
public class Test {

	@Id
	@GeneratedValue
	@Column(name="testId", unique = true)
	private int testId;
	
	@Column
	private String testName;
}
