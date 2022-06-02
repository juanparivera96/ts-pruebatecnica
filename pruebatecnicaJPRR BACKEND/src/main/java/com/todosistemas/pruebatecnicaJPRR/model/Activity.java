package com.todosistemas.pruebatecnicaJPRR.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "activity")
public class Activity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;

	@ManyToOne
    @JoinColumn(name = "employee_id")
    //@JsonIgnore
	private Employee employee;
	
   	@Column(name = "status")
   	private String status;
   	
   	@Column(name = "estimation_date")
   	private Timestamp estimationDate;
   	
   	@Column(name = "description")
   	private String description;
   	

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
   	
   	
	
}
