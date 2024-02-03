package com.goodbap.breadboard.restaurant.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.goodbap.breadboard.restaurant.domain.Restaurant;
import com.goodbap.breadboard.restaurant.dto.RequestDto;

@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {
    @Test
    public void getlistTest() {
        // given
        RequestDto request = new RequestDto("37.6595168", "127.3044679", "5000");
        List<Restaurant> response = new ArrayList<Restaurant>();
        // when

        // then
    }
}
