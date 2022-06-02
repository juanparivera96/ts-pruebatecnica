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

import com.todosistemas.pruebatecnicaJPRR.DTO.ActivityDTO;
import com.todosistemas.pruebatecnicaJPRR.model.Activity;
import com.todosistemas.pruebatecnicaJPRR.service.ActivityService;

@CrossOrigin(origins ="http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping(path = "/activity")
public class ActivityController {
	
	
    @Autowired
    private ActivityService activityService;
    
    @GetMapping("/find-all")
    public List<ActivityDTO> getAllActivities() {
        return activityService.getAllActivities();
    }
    
    @GetMapping("/findbyid/{activityId}")
    public Optional<Activity> getActivityById(@PathVariable Long activityId) {
        return activityService.getActivity(activityId);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        return activityService.save(activity);
    }

    @PutMapping("/update/{activityId}")
    public Activity updateActivity(@PathVariable Long activityId,@RequestBody Activity activity) {
        return activityService.updateActivity(activityId, activity);                
    }
    
    @DeleteMapping("/delete/{activityId}")
    public ResponseEntity<?> deleteActivity(@PathVariable Long activityId) {
        return activityService.deleteActivity(activityId);
    }
}
