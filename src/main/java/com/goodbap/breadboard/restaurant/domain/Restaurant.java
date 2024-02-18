package com.goodbap.breadboard.restaurant.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    // api호출 결과 나오는 정보들
    private String address_name;
    private String category_group_code;
    private String category_group_name;
    private String category_name;
    private String distance;
    private String id;
    private String phone;
    private String place_name;   // 프랜차이즈 이름이 포함되어 있는지 여부 비교
    private String place_url;
    private String road_address_name;
    private String x;
    private String y;
}
