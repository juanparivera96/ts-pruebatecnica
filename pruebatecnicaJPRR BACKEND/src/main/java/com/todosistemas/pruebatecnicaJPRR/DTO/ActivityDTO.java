package com.todosistemas.pruebatecnicaJPRR.DTO;

import java.sql.Timestamp;


import com.todosistemas.pruebatecnicaJPRR.model.Employee;

public class ActivityDTO {


	private Long id;
	private Employee employee;
   	private String status;
   	private Timestamp estimationDate;
   	private int delay;
   	private String description;
   	
   	
	public ActivityDTO(Long id, Employee employee, String status, Timestamp estimationDate, int delay, String description) {
		this.id = id;
		this.employee = employee;
		this.status = status;
		this.estimationDate = estimationDate;
		this.delay = delay;
		this.description = description;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Timestamp getEstimationDate() {
		return estimationDate;
	}


	public void setEstimationDate(Timestamp estimationDate) {
		this.estimationDate = estimationDate;
	}


	public int getDelay() {
		return delay;
	}


	public void setDelay(int delay) {
		this.delay = delay;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
   	
   	

   	
   	
   	
}
