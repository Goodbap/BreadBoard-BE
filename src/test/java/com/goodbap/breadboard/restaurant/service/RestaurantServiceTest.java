package com.goodbap.breadboard.restaurant.service;

import java.util.Map;
import java.util.HashMap;

import com.goodbap.breadboard.restaurant.dto.RequestDto;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantServiceTest {
    @Test
    public void getRestaurantsTest() {
        // given
        RequestDto dto = mock(RequestDto.class);
        Map<String, Object> response = new HashMap<String, Object>();
        RestaurantService service = mock(RestaurantService.class);  // mock객체(모의 객체) 생성
        when(service.getRestaurants(dto)).thenReturn(response); // 가짜 반환값 설정(stubbing)
        // when
        Map<String, Object> result = service.getRestaurants(dto);
        // then
        assertThat(result).isEqualTo(response);
    }
}
