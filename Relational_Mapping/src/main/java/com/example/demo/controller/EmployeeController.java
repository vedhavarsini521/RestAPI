package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.request.EmployeeRequest;

@RestController
public class EmployeeController {
	@Autowired
	DepartmentRepo dRepository;
	@Autowired
	EmployeeRepo eRepository;
	
	@PostMapping("/employee")
	public Employee saveEmployee(@Validated @RequestBody EmployeeRequest eRequest) {
		Department department=new Department();
		department.setName(eRequest.getDepartment());
		department=dRepository.save(department);
		Employee employee=new Employee(eRequest);
		employee.setDept(department);
		eRepository.save(employee);
		return employee;
	}
	
	@GetMapping("/employee")
	public List<Employee>getEmployees()
	{
		return eRepository.findAll();
	}
	
	@GetMapping("/department")
	public List<Department>getDepartment()
	{
		return dRepository.findAll();
	}
	

}
