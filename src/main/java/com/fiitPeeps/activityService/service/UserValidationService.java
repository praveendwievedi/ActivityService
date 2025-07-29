package com.fiitPeeps.activityService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
//import org.fittPeeps.activityService.config.RestclientConfig.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
public class UserValidationService {
//    private final WebClient userServiceWebClient;
    private final RestClient userServiceRestClient;
//    public UserValidationService(RestClient.Builder restClientBuilder) {
//        this.restClient = restClientBuilder.build();
//    }

    @Value("${user.service.uri}")
    private String uri;

    public Boolean isValidUser(String userId){
//        try {
////         return userServiceWebClient.get()
////                 .uri("/api/user/{userId}/validate",userId)
////                 .retrieve()
////                 .bodyToMono(boolean.class)
////                 .block();
////        }
//            return restClient.get()
//                    .uri(uri)
//                    .retrieve()
//                    .body(Boolean.class);
//        }
//        catch (WebClientResponseException e){
//            if(e.getStatusCode() == HttpStatus.NOT_FOUND){
//                throw new RuntimeException("User not found with id:" + userId);
//            }
//        }
        Boolean response=userServiceRestClient.get()
                .uri(uri+"/api/user/{userId}/validate", userId)
                .retrieve()
                .body(Boolean.class);
        return  response;
    }
}
