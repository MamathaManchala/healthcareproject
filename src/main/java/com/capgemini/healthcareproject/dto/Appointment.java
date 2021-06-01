package com.capgemini.healthcareproject.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "appointment_info")
public class Appointment {
	
	@Id
	@GeneratedValue
	@Column(name = "appointmentId")
	private int appointmentId;
	
	@Column(name = "userId", unique = true)
	private int userId;
	
	
	@Column(name = "date")
	private String appointmentDate;

	@Column(name = "time")
	private String appointmentTime;

	
	

}
