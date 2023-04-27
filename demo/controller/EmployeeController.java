package com.colllistset.demo.controller;

import com.colllistset.demo.model.Employee;
import com.colllistset.demo.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")


public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String secondName) {
        return employeeService.add(firstName, secondName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,
                        @RequestParam String secondName) {
        return employeeService.add(firstName, secondName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                        @RequestParam String secondName) {
        return employeeService.add(firstName, secondName);
    }

    @GetMapping
    public Collection<Employee> employees() {
        return employeeService.employees();
    }

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }
}
