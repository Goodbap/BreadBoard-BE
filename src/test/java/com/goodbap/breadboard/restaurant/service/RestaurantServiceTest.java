package com.goodbap.breadboard.restaurant.service;

import java.util.ArrayList;
import java.util.List;

import com.goodbap.breadboard.restaurant.domain.Restaurant;
import com.goodbap.breadboard.restaurant.dto.RequestDto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RestaurantServiceTest {
    @Test
    public void getRestaurantsTest() {
        // given
        RequestDto dto = mock(RequestDto.class);
        List<Restaurant> response = new ArrayList<Restaurant>();
        RestaurantService service = mock(RestaurantService.class);  // mock객체(모의 객체) 생성
        when(service.getRestaurants(dto)).thenReturn(response); // 가짜 반환값 설정(stubbing)
        // when
        List<Restaurant> result = service.getRestaurants(dto);
        // then
        assertThat(result).isEqualTo(response);
    }
}
