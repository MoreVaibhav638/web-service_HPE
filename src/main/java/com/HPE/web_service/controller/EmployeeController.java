package com.HPE.web_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HPE.web_service.entity.Employees;
import com.HPE.web_service.service.EmployeeService;

@RestController
public class EmployeeController {

   @Autowired
   private EmployeeService employeeService;

    @GetMapping("/employees")
    public Employees getEmployees() {
        return employeeService.getAllEmployees();
    }
}