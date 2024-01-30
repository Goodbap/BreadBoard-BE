package com.goodbap.breadboard.restaurant.service;

import java.util.Map;

import com.goodbap.breadboard.restaurant.dto.RequestDto;

import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RestaurantService {
    WebClient webClient;

    public RestaurantService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Map<String, Object> getRestaurants(RequestDto dto) {
        try {
            Map<String, Object> response = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("category_group_code", "FD6")
                            .queryParam("y", dto.getLatitude())
                            .queryParam("x", dto.getLongitude())
                            .queryParam("radius", dto.getRadius())
                            .build())
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
            return response;
        } catch (ErrorResponseException e) {
            // System.out.println(e.getMessage());
            throw e;
        }
        /*
         * 응답결과
         * {documents : list<object<식당정보>>, meta : object}
         */
    }
}
