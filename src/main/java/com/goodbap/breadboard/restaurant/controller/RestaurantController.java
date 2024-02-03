package com.goodbap.breadboard.restaurant.controller;

import java.util.List;

import com.goodbap.breadboard.restaurant.domain.Restaurant;
import com.goodbap.breadboard.restaurant.dto.RequestDto;
import com.goodbap.breadboard.restaurant.service.RestaurantService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class RestaurantController {

    RestaurantService service;

    public RestaurantController(RestaurantService service){
        this.service = service;
    }

    @PostMapping("/restaurant-list")    //non-filtering
    public List<Restaurant> getlist(@RequestBody RequestDto dto) {
        return service.getRestaurants(dto);
    }
}
