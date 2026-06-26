package com.HPE.web_service.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.HPE.web_service.entity.Employee;
import com.HPE.web_service.entity.Employees;
import com.HPE.web_service.service.EmployeeService;
public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void testGetAllEmployees() {

        Employees employees = employeeService.getAllEmployees();

        assertNotNull(employees);
        assertEquals(3, employees.getEmployeeList().size());
    }

    @Test
    void testAddEmployee() {

        Employee employee = new Employee(
                "EMP004",
                "Vaibhav",
                "More",
                "vaibhav.more@hpe.com",
                "Java Developer");

        Employee savedEmployee = employeeService.addEmployee(employee);

        assertNotNull(savedEmployee);
        assertEquals("EMP004", savedEmployee.getEmployee_id());

        assertEquals(4,
                employeeService.getAllEmployees()
                               .getEmployeeList()
                               .size());
    }

    @Test
    void testEmployeeName() {

        Employee employee = employeeService
                .getAllEmployees()
                .getEmployeeList()
                .get(0);

        assertEquals("John", employee.getFirst_name());
    }

    @Test
    void testEmployeeEmail() {

        Employee employee = employeeService
                .getAllEmployees()
                .getEmployeeList()
                .get(1);

        assertEquals("jane.smith@example.com",
                employee.getEmail());
    }

}