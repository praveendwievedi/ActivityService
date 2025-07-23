package com.fiitPeeps.activityService.models;

import lombok.*;
import org.springframework.aot.generate.Generated;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "activities")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    private String id;
    private String userId;
    private Integer caloriesBurned;
    private Integer duration;
    private ActivityType activityType;
    private LocalDateTime startTime;

    @Field("metrics")
    private Map<String,Object> additional;

    @CreatedDate// we are using this because we are not using jpa this comes from spring framework
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
