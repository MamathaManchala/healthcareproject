package com.capgemini.healthcareproject.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "center_info")
public class DiagnosticCenter {
	
	@Id
	@GeneratedValue
	@Column(name = "centerId", unique = true)
	private int centerId;
	
	@Column(name = "centerName")
	private String centerName;
	
	@Column
	private String phoneNo;
	
	@Column
	private String address;
	
	
	

}
