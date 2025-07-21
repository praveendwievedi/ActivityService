package com.fiitPeeps.activityService.repository;

import com.fiitPeeps.activityService.models.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRespository extends MongoRepository<Activity,String> {
}
