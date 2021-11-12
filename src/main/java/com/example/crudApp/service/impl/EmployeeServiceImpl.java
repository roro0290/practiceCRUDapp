package com.example.crudApp.service.impl;

import com.example.crudApp.exception.ResourceNotFoundException;
import com.example.crudApp.model.Employee;
import com.example.crudApp.repo.EmployeeRepository;
import com.example.crudApp.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Employee getEmployeeById(Long id) {
        /* Optional<Employee> employee= employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new ResourceNotFoundException("Employee","id",id);
        }*/
        return employeeRepository.findById(id).orElseThrow( () ->
                new ResourceNotFoundException("Employee","id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee,long id) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        return employeeRepository.save(existingEmployee); //will update existing based on id
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee existingEmployee = getEmployeeById(id);
        employeeRepository.delete(existingEmployee);
    }

}
