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

import com.capgemini.healthcareproject.dto.DiagnosticCenter;
import com.capgemini.healthcareproject.response.CenterResponse;
import com.capgemini.healthcareproject.service.DiagnosticCenterService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class DiagnosticCenterController {

	@Autowired
	DiagnosticCenterService centerService;
	
	@PostMapping(path = "/add-center", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CenterResponse addCenter(@RequestBody DiagnosticCenter center) {
		CenterResponse centerResponse = new CenterResponse();
		if (centerService.addCenter(center)) {
			centerResponse.setStatusCode(201);
			centerResponse.setMessage("Success");
			centerResponse.setDescription("Center Added Successfully");
		}
		return centerResponse;
	}
	
	
	@DeleteMapping(path = "/delete-center/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CenterResponse deleteCenter(@PathVariable("centerId") int centerId) {
		CenterResponse centerResponse = new CenterResponse();
		if (centerService.deleteCenter(centerId)) {
			centerResponse.setStatusCode(201);
			centerResponse.setMessage("Success");
			centerResponse.setDescription("Center Deleted Successfully");
		}
		return centerResponse;
	}
	
	
	@GetMapping(path = "/get-all-center", produces = MediaType.APPLICATION_JSON_VALUE)
	public CenterResponse getAllCenter() {
		CenterResponse centerResponse = new CenterResponse();
		List<DiagnosticCenter> centerList = centerService.getAllCenter();
		if (centerList.size() != 0) {
			centerResponse.setStatusCode(201);
			centerResponse.setMessage("Success");
			centerResponse.setDescription("Center Found Successfully");
			centerResponse.setCenter(centerList);
			return centerResponse;
		}
		return centerResponse;
	}
	
	
	@PutMapping(path = "/modify-center", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CenterResponse updateCenter(@RequestBody DiagnosticCenter center) {
		CenterResponse centerResponse = new CenterResponse();
		if (centerService.updateCenter(center)) {
			centerResponse.setStatusCode(201);
			centerResponse.setMessage("Success");
			centerResponse.setDescription("Center Modified Successfully");
		}
		return centerResponse;
	}
	

}
