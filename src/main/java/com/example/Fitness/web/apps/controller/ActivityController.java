package com.example.Fitness.web.apps.controller;

import com.example.Fitness.web.apps.Dto.ActivityRequest;
import com.example.Fitness.web.apps.Dto.ActivityResponse;
import com.example.Fitness.web.apps.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping("/create")
    public ResponseEntity<ActivityResponse> createActivity(@RequestBody ActivityRequest activityRequest){
        return ResponseEntity.ok(activityService.createActivity(activityRequest));
    }

}