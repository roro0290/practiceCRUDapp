package com.example.crudApp.service;

import com.example.crudApp.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee,long id);
    void deleteEmployeeById(Long id);
}
