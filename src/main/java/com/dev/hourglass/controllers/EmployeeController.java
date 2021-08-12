package com.dev.hourglass.controllers;

import com.dev.hourglass.models.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    // Allows the creation of a new employee
    @PostMapping("/createEmployee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {

        return new ModelAndView("createEmployee");
    }

    // Makes an API call to add the new employee information to the user XML file
    @PostMapping("/addEmployee")
    public String addUser(@ModelAttribute Employee employee) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:4000/employee/register";

        restTemplate.postForObject(
                apiUrl,
                employee,
                ResponseEntity.class);

        return "login";
    }
}