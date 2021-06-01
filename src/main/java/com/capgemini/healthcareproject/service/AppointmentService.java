package com.capgemini.healthcareproject.service;

import java.util.ArrayList;

import com.capgemini.healthcareproject.dto.Appointment;

public interface AppointmentService {
	  public boolean addAppointment(Appointment appointment);
	  
	  public boolean deleteAppointment(int testId);
		
      public boolean updateAppointment(Appointment appointment);
			
	  public ArrayList<Appointment> getAllAppointment();

}
