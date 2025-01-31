package com.spring.glider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.glider.dto.EmpDTO;
import com.spring.glider.service.impl.EmpServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	EmpServiceImpl empServiceImpl;
	
	@RequestMapping(value="/get",method = RequestMethod.GET)
	ResponseEntity<EmpDTO> getEmployeeDetails(@RequestParam("eid") int eid){
		
		EmpDTO empDTO=empServiceImpl.getEmpInfo(eid);
		return new ResponseEntity<>(empDTO, HttpStatus.OK);
	}
}
