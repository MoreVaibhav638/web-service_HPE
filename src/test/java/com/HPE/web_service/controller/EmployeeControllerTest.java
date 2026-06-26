package com.HPE.web_service.controller;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.HPE.web_service.controller.EmployeeController;
import com.HPE.web_service.entity.Employee;
import com.HPE.web_service.entity.Employees;
import com.HPE.web_service.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @org.springframework.test.context.bean.override.mockito.MockitoBean
    private EmployeeService employeeService;

    @Test
    void testGetEmployees() throws Exception {

        Employees employees = new Employees();

        employees.setEmployeeList(Arrays.asList(
                new Employee("EMP001",
                        "John",
                        "Doe",
                        "john.doe@example.com",
                        "Software Engineer")
        ));

        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeList[0].employee_id")
                        .value("EMP001"))
                .andExpect(jsonPath("$.employeeList[0].first_name")
                        .value("John"));
    }

    @Test
    void testAddEmployee() throws Exception {

        Employee employee = new Employee(
                "EMP004",
                "Vaibhav",
                "More",
                "vaibhav.more@hpe.com",
                "Java Developer");

        when(employeeService.addEmployee(org.mockito.ArgumentMatchers.any(Employee.class)))
                .thenReturn(employee);

        String json = """
                {
                  "employee_id":"EMP004",
                  "first_name":"Vaibhav",
                  "last_name":"More",
                  "email":"vaibhav.more@hpe.com",
                  "title":"Java Developer"
                }
                """;

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employee_id")
                        .value("EMP004"))
                .andExpect(jsonPath("$.first_name")
                        .value("Vaibhav"));
    }

}