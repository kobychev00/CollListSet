package com.colllistset.demo.service;

import com.colllistset.demo.exception.EmployeeAlreadyAddedException;
import com.colllistset.demo.exception.EmployeeNotFoundException;
import com.colllistset.demo.exception.EmployeeStorageIsFullException;
import com.colllistset.demo.model.Employee;

import java.util.*;

public class EmployeeService {

    private static final int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(String firstName, String secondName) {
        return firstName + " " + secondName;
    }



    public Employee add(String firstName, String secondName) {
        if (employees.size() == LIMIT) {
            throw new EmployeeStorageIsFullException();
        }
        String key = getKey(firstName, secondName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(firstName, secondName);
        employees.put(key, employee);
        return employee;
    }

    public Employee remove(String firstName, String secondName) {
        String key = getKey(firstName, secondName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public Employee find(String firstName, String secondName) {
        String key = getKey(firstName, secondName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }


    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

}

