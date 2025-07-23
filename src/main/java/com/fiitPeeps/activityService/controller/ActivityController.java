package com.fiitPeeps.activityService.controller;

import com.fiitPeeps.activityService.dto.ActivityRequest;
import com.fiitPeeps.activityService.dto.ActivityResponse;
import com.fiitPeeps.activityService.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {
    private ActivityService activityService;

    @PostMapping("/register")
    public ResponseEntity<ActivityResponse> registerActivity(@RequestBody ActivityRequest request){
        System.out.println(request);
        return ResponseEntity.ok(activityService.registerActivity(request));
    }
    @GetMapping("/")
    public ResponseEntity<List<ActivityResponse>> getActivities(@RequestHeader(name = "X-User-ID") String userId){
        return ResponseEntity.ok(activityService.getActivities(userId));
    }
    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityResponse> getActivityById(@PathVariable String activityId){
      return ResponseEntity.ok(activityService.getActivityById(activityId));
    }
}
