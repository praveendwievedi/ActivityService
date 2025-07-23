package com.fiitPeeps.activityService.repository;

import com.fiitPeeps.activityService.models.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ActivityRespository extends MongoRepository<Activity,String> {
    List<Activity> findByUserId(String userId);
}
