package com.capgemini.healthcareproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcareproject.dao.AppointmentDao;
import com.capgemini.healthcareproject.dto.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentDao appointmentDao;

	@Override
	public boolean addAppointment(Appointment appointment) {
		return appointmentDao.addAppointment(appointment);
	}

	@Override
	public boolean deleteAppointment(int testId) {
		return appointmentDao.deleteAppointment(testId);
	}

	@Override
	public boolean updateAppointment(Appointment appointment) {
		return appointmentDao.updateAppointment(appointment);
	}

	@Override
	public ArrayList<Appointment> getAllAppointment() {
		return appointmentDao.getAllAppointment();
	}

}
