package com.fiitPeeps.activityService.dto;

import com.fiitPeeps.activityService.models.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityResponse {
    private String activityId;
    private String userId;
    private Integer caloriesBurned;
    private Integer duration;
    private ActivityType activityType;
    private LocalDateTime startTime;
    private Map<String,Object> additional;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
