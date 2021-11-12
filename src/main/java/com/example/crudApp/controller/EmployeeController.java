package com.example.crudApp.controller;

import com.example.crudApp.model.Employee;
import com.example.crudApp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.FOUND);
    }

    // https://localhost:8080/api/employees/1
    // employee object is in the body while id is in the url
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.updateEmployee(employee,id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }
}
