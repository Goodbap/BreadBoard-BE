package com.goodbap.breadboard.restaurant.controller;

import java.util.List;

import com.goodbap.breadboard.restaurant.service.RestaurantService;
import com.goodbap.breadboard.restaurant.domain.Restaurant;
import com.goodbap.breadboard.restaurant.dto.CoordRequestDto;
import com.goodbap.breadboard.restaurant.dto.KeywordRequestDto;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class RestaurantController {
    private final RestaurantService service;

    public RestaurantController(RestaurantService service){
        this.service = service;
    }

    @PostMapping("/coord/restaurant-list")  // 좌표를 이용한 주변 음식점 탐색
    public List<Restaurant> getlistByCoord(@RequestBody CoordRequestDto dto) {
        return service.getRestaurantsByCoord(dto);
    }
    
    @PostMapping("/keyword/restaurant-list")    //키워드를 이용한 음식점 탐색
    public List<Restaurant> getlistByKeyword(@RequestBody KeywordRequestDto dto) {
        return service.getRestaurantsBykeyword(dto);
    }
}
