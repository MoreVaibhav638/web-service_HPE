package com.HPE.web_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HPE.web_service.entity.Employee;
import com.HPE.web_service.entity.Employees;
import com.HPE.web_service.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

   @Autowired
   private EmployeeService employeeService;

    @GetMapping
    public Employees getEmployees() {
        return employeeService.getAllEmployees();
    }
    
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
    	return employeeService.addEmployee(employee);
    }
}
