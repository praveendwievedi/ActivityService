package com.fiitPeeps.activityService.service;

//import com.fiitPeeps.activityService.ActivityRepository.ActivityResponse;
import com.fiitPeeps.activityService.repository.ActivityRespository;
import com.fiitPeeps.activityService.dto.ActivityRequest;
import com.fiitPeeps.activityService.dto.ActivityResponse;
import com.fiitPeeps.activityService.models.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRespository activityRespository;

    public ActivityResponse registerActivity(ActivityRequest request) {
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
        activityResponse.setUserId(savedActivity.getUserId());
        activityResponse.setAdditional(savedActivity.getAdditional());
        activityResponse.setActivityType(savedActivity.getActivityType());
        activityResponse.setCaloriesBurned(savedActivity.getCaloriesBurned());
        activityResponse.setStartTime(savedActivity.getStartTime());
        activityResponse.setDuration(savedActivity.getDuration());
        return activityResponse;
    }
}
