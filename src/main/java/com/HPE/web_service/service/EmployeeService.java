package com.HPE.web_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.HPE.web_service.entity.Employee;
import com.HPE.web_service.entity.Employees;

@Service
public class EmployeeService {
	 public Employees getAllEmployees() {

	        List<Employee> employeeList = new ArrayList<>();

	        employeeList.add(new Employee(
	                "EMP001",
	                "John",
	                "Doe",
	                "john.doe@example.com",
	                "Software Engineer"));

	        employeeList.add(new Employee(
	                "EMP002",
	                "Jane",
	                "Smith",
	                "jane.smith@example.com",
	                "QA Engineer"));

	        employeeList.add(new Employee(
	                "EMP003",
	                "David",
	                "Johnson",
	                "david.johnson@example.com",
	                "Project Manager"));

	        return new Employees(employeeList);
	    }
	}
