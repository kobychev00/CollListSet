package com.colllistset.demo.service;

import com.colllistset.demo.exception.EmployeeAlreadyAddedException;
import com.colllistset.demo.exception.EmployeeNotFoundException;
import com.colllistset.demo.exception.EmployeeStorageIsFullException;
import com.colllistset.demo.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EmployeeService {

    private static final int SIZE = 3;

    private final Collection<Employee> employees = new ArrayList<>();

    public Employee add(String firstName, String secondName) {
        if (employees.size() < SIZE) {
            Employee employee = new Employee(firstName, secondName);
            if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();

    }

    public Employee remove(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (!employees.contains(employees)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee find(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (!employees.contains(employees)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> employees() {
        return Collections.unmodifiableCollection(employees);
    }

}

