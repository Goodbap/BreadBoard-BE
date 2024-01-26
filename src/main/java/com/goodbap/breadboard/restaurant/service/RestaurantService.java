package com.goodbap.breadboard.restaurant.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.goodbap.breadboard.restaurant.dto.RequestDto;

@Service
public class RestaurantService {
    WebClient webClient;

    public RestaurantService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Map<String, Object> getRestaurants(RequestDto dto) {
        Map<String, Object> response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("category_group_code", "FD6")
                        .queryParam("y", dto.getLatitude())
                        .queryParam("x", dto.getLongitude())
                        .queryParam("radius", dto.getRadius())
                        .build())
                .retrieve()
                .bodyToMono(Map.class)
                .block();   //예외처리 필요
        return response;
    }
}
