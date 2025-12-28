package com.example.Fitness.web.apps.repository;

import com.example.Fitness.web.apps.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
