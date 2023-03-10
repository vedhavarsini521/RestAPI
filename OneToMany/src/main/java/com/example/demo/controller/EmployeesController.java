package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeesRepository;

@RestController
public class EmployeesController {
	@Autowired
	private EmployeesRepository empRepository;
	
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployees(@RequestBody Employees empData){
		empRepository.save(empData);
		return ResponseEntity.ok("Data saved");
	}
	
	@GetMapping("/employees")
	public List<Employees> getEmployees(){
		return empRepository.findAll();
	}
}
