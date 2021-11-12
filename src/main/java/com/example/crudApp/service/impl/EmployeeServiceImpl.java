package com.example.crudApp.service.impl;

import com.example.crudApp.model.Employee;
import com.example.crudApp.repo.EmployeeRepository;
import com.example.crudApp.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

//a class which implements the Employee Service interface
//before implementing, we need to inject the employeeRepository dependency
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
