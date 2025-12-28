package com.example.Fitness.web.apps.service;

import com.example.Fitness.web.apps.Dto.ActivityRequest;
import com.example.Fitness.web.apps.Dto.ActivityResponse;
import com.example.Fitness.web.apps.model.Activity;
import com.example.Fitness.web.apps.model.User;
import com.example.Fitness.web.apps.repository.ActivityRepository;
import com.example.Fitness.web.apps.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityResponse createActivity(ActivityRequest request) {

        if (request.getUserId() == null) {
            throw new RuntimeException("userId is required");
        }

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Activity activity = new Activity();
        activity.setUser(user);
        activity.setType(request.getType());
        activity.setDuration(request.getDuration());
        activity.setCaloriesBurned(request.getCaloriesBurned());
        activity.setStartTime(request.getStartTime());
        activity.setAdditionalMetrics(request.getAdditionalMetrics());

        Activity saved = activityRepository.save(activity);

        return new ActivityResponse(
                saved.getId(),
                user.getId(),
                saved.getType(),
                saved.getAdditionalMetrics(),
                saved.getDuration(),
                saved.getCaloriesBurned(),
                saved.getStartTime(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
        );
    }
}
