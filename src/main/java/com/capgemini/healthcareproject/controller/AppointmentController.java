package com.capgemini.healthcareproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcareproject.dto.Appointment;
import com.capgemini.healthcareproject.response.AppointmentResponse;
import com.capgemini.healthcareproject.service.AppointmentService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping(path = "/add-appointment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse addAppointment(@RequestBody Appointment appointment) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (appointmentService.addAppointment(appointment)) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Added Successfully");
		}
		return appointmentResponse;
	}
	
	
	@DeleteMapping(path = "/delete-appointment/{appointmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse deleteAppointment(@PathVariable("appointmentId") int appointmentId) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (appointmentService.deleteAppointment(appointmentId)) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Deleted Successfully");
		}
		return appointmentResponse;
	}
	
	
	@GetMapping(path = "/get-all-appointment", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse getAllAppoitment() {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		List<Appointment> appointmentList = appointmentService.getAllAppointment();
		if (appointmentList.size() != 0) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Found Successfully");
			appointmentResponse.setAppointment(appointmentList);
			return appointmentResponse;
		}
		return appointmentResponse;
	}
	
	
	@PutMapping(path = "/modify-appointment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse updateAppointment(@RequestBody Appointment appointment) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (appointmentService.updateAppointment(appointment)) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Modified Successfully");
		}
		return appointmentResponse;
	}
	


}
