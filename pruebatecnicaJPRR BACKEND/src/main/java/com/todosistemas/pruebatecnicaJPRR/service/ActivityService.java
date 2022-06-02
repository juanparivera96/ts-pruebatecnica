package com.todosistemas.pruebatecnicaJPRR.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.todosistemas.pruebatecnicaJPRR.DTO.ActivityDTO;
import com.todosistemas.pruebatecnicaJPRR.exceptions.ResourceNotFoundException;
import com.todosistemas.pruebatecnicaJPRR.model.Activity;
import com.todosistemas.pruebatecnicaJPRR.repository.ActivityRepository;


@Service
public class ActivityService {

	@Autowired
    private ActivityRepository activityRepository;
	
	
	public Optional<Activity> getActivity(Long activityId) {
		return activityRepository.findById(activityId);
	}
	
    public List<ActivityDTO> getAllActivities(){
    	List<Activity> activities = activityRepository.findAll();
    	List<ActivityDTO> activitiesDTO = new ArrayList<ActivityDTO>();
    	for(Activity act: activities) {
    		Date fecha1 = act.getEstimationDate();
    		Date fecha2 = new Date();
    		int dias=(int) ((fecha2.getTime()-fecha1.getTime())/86400000);  
    		if(dias <=0)dias = 0;
    		ActivityDTO dto = new ActivityDTO(act.getId(), act.getEmployee(), act.getStatus(), act.getEstimationDate(), dias, act.getDescription());
    		activitiesDTO.add(dto);
    	}
    	
    	return activitiesDTO;
    }
    
    
    public ResponseEntity<Activity> save(Activity activity) {
        return new ResponseEntity<Activity>(activityRepository.save(activity), HttpStatus.CREATED);
    }
    
    
    public Activity updateActivity(Long activityId, Activity activityRequest) {
    	return activityRepository.findById(activityId).map(activity -> {
    		activity.setStatus(activityRequest.getStatus());
    		activity.setEstimationDate(activityRequest.getEstimationDate());
    		activity.setDescription(activityRequest.getDescription());
    		activity.setEmployee(activityRequest.getEmployee());
        	activityRepository.save(activity);
            return activityRepository.save(activity);
        }).orElseThrow(() -> new ResourceNotFoundException("Activity not found with id " + activityId));                
    }
    
    public ResponseEntity<?> deleteActivity(Long activityId){
    	if(!activityRepository.existsById(activityId)) {
            throw new ResourceNotFoundException("Activity not found with id " + activityId);
        }
        return activityRepository.findById(activityId)
                .map(activity -> {
                	activityRepository.delete(activity);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Activity not found with id " + activityId));
    }

}
