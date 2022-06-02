package com.todosistemas.pruebatecnicaJPRR.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todosistemas.pruebatecnicaJPRR.exceptions.ResourceNotFoundException;
import com.todosistemas.pruebatecnicaJPRR.model.Employee;
import com.todosistemas.pruebatecnicaJPRR.repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	@Autowired
    private EmployeeRepository employeeRepository;
	
    public List<Employee> getAllEmployees(){
    	return employeeRepository.findAll();
    }
    
    public Optional<Employee> getEmployeeById(Long employeeId) {
    	return employeeRepository.findById(employeeId);
    }
    
    public ResponseEntity<Employee> save(Employee activity) {
        return new ResponseEntity<Employee>(employeeRepository.save(activity), HttpStatus.CREATED);
    }
    
    
    public Employee updateEmployee(Long employeeId, Employee employeeRequest) {
    	return employeeRepository.findById(employeeId).map(employee -> {
    		employee.setName(employeeRequest.getName());
    		employeeRepository.save(employee);
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + employeeId));                
    }
    
    public ResponseEntity<?> deleteEmployee(Long employeeId){
    	if(!employeeRepository.existsById(employeeId)) {
            throw new ResourceNotFoundException("Employee not found with id " + employeeId);
        }
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                	employeeRepository.delete(employee);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + employeeId));

    }
}
