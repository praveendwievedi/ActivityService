package com.fiitPeeps.activityService.service;

//import com.fiitPeeps.activityService.ActivityRepository.ActivityResponse;
import com.fiitPeeps.activityService.repository.ActivityRespository;
import com.fiitPeeps.activityService.dto.ActivityRequest;
import com.fiitPeeps.activityService.dto.ActivityResponse;
import com.fiitPeeps.activityService.models.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRespository activityRespository;
    private final UserValidationService userValidationService;

    public ActivityResponse registerActivity(ActivityRequest request) {
        if(!userValidationService.isValidUser(request.getUserId())){
            throw new RuntimeException("User Not valid");
        }
        Activity activity=Activity.builder()
                .userId(request.getUserId())
                .activityType(request.getActivityType())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additional(request.getAdditional())
                .duration(request.getDuration())
                .build();
        Activity savedActivity=activityRespository.save(activity);
        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity savedActivity) {
        ActivityResponse activityResponse=new ActivityResponse();
        activityResponse.setId(savedActivity.getId());
        activityResponse.setUserId(savedActivity.getUserId());
        activityResponse.setAdditional(savedActivity.getAdditional());
        activityResponse.setActivityType(savedActivity.getActivityType());
        activityResponse.setCaloriesBurned(savedActivity.getCaloriesBurned());
        activityResponse.setStartTime(savedActivity.getStartTime());
        activityResponse.setDuration(savedActivity.getDuration());
        activityResponse.setCreatedAt(savedActivity.getCreatedAt());
        activityResponse.setUpdatedAt(savedActivity.getUpdatedAt());
        return activityResponse;
    }

    public List<ActivityResponse> getActivities(String userId) {
        List<Activity> activities=activityRespository.findByUserId(userId);
        return activities.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ActivityResponse getActivityById(String id){
        return activityRespository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(()-> new RuntimeException("No such activity found with id : " + id));
    }
}
