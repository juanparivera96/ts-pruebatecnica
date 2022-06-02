package com.todosistemas.pruebatecnicaJPRR.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todosistemas.pruebatecnicaJPRR.model.Employee;
import com.todosistemas.pruebatecnicaJPRR.service.EmployeeService;

@CrossOrigin(origins ="http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
	
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/find-all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    
    @GetMapping("/findbyid/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Employee> createActivity(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/update/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeId, employee);                
    }
    
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

}
