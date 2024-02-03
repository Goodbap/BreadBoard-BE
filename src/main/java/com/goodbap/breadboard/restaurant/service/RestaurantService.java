package com.goodbap.breadboard.restaurant.service;

import java.util.List;
import java.util.Map;

import com.goodbap.breadboard.restaurant.domain.Restaurant;
import com.goodbap.breadboard.restaurant.dto.RequestDto;

import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RestaurantService {
    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://dapi.kakao.com/v2/local/search/category.json")
            .defaultHeader("Authorization", "KakaoAK api-key")
            .build();

    public List<Restaurant> getRestaurants(RequestDto dto) throws ErrorResponseException {
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
        List<Restaurant> restaurantList = (List<Restaurant>)response.get("documents");
        return restaurantList;
        /*
         * 응답결과
         * {documents : list<object<식당정보>>, meta : object}
         */
    }
}
