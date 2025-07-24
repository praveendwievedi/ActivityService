package com.fiitPeeps.activityService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
public class UserValidationService {
    private final WebClient userServiceWebClient;

    public Boolean isValidUser(String userId){
        try{
         return userServiceWebClient.get()
                 .uri("/api/user/{userId}/validate",userId)
                 .retrieve()
                 .bodyToMono(boolean.class)
                 .block();
        }
        catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.NOT_FOUND){
                throw new RuntimeException("User not found with id:" + userId);
            }
        }
        return  false;
    }
}
