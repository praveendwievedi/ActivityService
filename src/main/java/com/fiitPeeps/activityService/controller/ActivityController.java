package com.fiitPeeps.activityService.controller;

import com.fiitPeeps.activityService.dto.ActivityRequest;
import com.fiitPeeps.activityService.dto.ActivityResponse;
import com.fiitPeeps.activityService.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
