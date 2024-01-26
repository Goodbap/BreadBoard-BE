package com.goodbap.breadboard.restaurant.controller;

import org.springframework.web.bind.annotation.RestController;

import com.goodbap.breadboard.restaurant.dto.RequestDto;
import com.goodbap.breadboard.restaurant.service.RestaurantService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")

public class RestaurantController {

    RestaurantService service;

    public RestaurantController(RestaurantService service){
        this.service = service;
    }

    @PostMapping("/restaurant-list")
    public Map<String, Object> getlist(@RequestBody RequestDto dto) {
        return service.getRestaurants(dto);
    }
}
