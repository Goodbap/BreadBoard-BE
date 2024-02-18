package com.goodbap.breadboard.restaurant.controller;

import java.util.List;

import com.goodbap.breadboard.restaurant.service.RestaurantService;
import com.goodbap.breadboard.restaurant.domain.Restaurant;
import com.goodbap.breadboard.restaurant.dto.RequestDto;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class RestaurantController {
    private final RestaurantService service;

    public RestaurantController(RestaurantService service){
        this.service = service;
    }

    @PostMapping("/coord/restaurant-list")
    public List<Restaurant> getlist(@RequestBody RequestDto dto) {
        return service.getFilteredRestaurants(dto);
    }
}
