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

import com.capgemini.healthcareproject.dto.Test;
import com.capgemini.healthcareproject.response.TestResponse;
import com.capgemini.healthcareproject.service.TestService;



@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class TestController {
	
	
	@Autowired
	TestService testService;
	
	@PostMapping(path = "/add-test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse addTest(@RequestBody Test test) {
		TestResponse testResponse = new TestResponse();
		if (testService.addTest(test)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Added Successfully");
		}
		return testResponse;
	}
	
	
	@DeleteMapping(path = "/delete-test/{testId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse deleteTest(@PathVariable("testId") int testId) {
		TestResponse testResponse = new TestResponse();
		if (testService.deleteTest(testId)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Deleted Successfully");
		}
		return testResponse;
	}
	
	
	@GetMapping(path = "/get-all-test", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse getAllTest() {
		TestResponse testResponse = new TestResponse();
		List<Test> testList = testService.getAllTest();
		if (testList.size() != 0) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Found Successfully");
			testResponse.setTest(testList);
			return testResponse;
		}
		return testResponse;
	}
	
	
	@PutMapping(path = "/modify-test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse updateTest(@RequestBody Test test) {
		TestResponse testResponse = new TestResponse();
		if (testService.updateTest(test)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Modified Successfully");
		}
		return testResponse;
	}
	

}
