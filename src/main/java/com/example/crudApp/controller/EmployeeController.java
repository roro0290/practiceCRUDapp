package com.example.crudApp.controller;

import com.example.crudApp.model.Employee;
import com.example.crudApp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees") //base URL
public class EmployeeController {
    private EmployeeService employeeService;

    //Use constructor-based DI
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //build create employee REST API
    //ResponseEntity class  complete response details such as status, header can be added
    @PostMapping() //Post request has an employee JSON object which we need to bind to the object in the method
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
        //this REST API will create the resource
    }
}
