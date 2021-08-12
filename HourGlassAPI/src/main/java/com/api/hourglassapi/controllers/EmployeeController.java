package com.api.hourglassapi.controllers;


import com.api.hourglassapi.models.Employee;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static com.api.hourglassapi.repositories.EmployeeUtil.readEmployee;
import static com.api.hourglassapi.repositories.EmployeeUtil.registerEmployee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    // Registers a new employee to the XML file
    @PostMapping("/register")
    public void register(@RequestBody Employee newEmployee) throws IOException
    {
        registerEmployee(newEmployee);
    }

    // Returns the list of stored users
    @GetMapping("/validate")
    public List<Employee> validate() {
        List<Employee> employees = readEmployee();

        return employees;
    }


    // Used for testing API access
    @GetMapping("/ping")
    public String getPing() {
        return "OK";
    }
}
