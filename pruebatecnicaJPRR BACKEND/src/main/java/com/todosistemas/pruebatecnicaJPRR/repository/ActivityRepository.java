package com.todosistemas.pruebatecnicaJPRR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todosistemas.pruebatecnicaJPRR.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{

}
