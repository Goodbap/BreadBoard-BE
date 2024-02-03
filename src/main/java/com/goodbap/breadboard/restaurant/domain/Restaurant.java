package com.goodbap.breadboard.restaurant.domain;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class Restaurant {
    // api호출 결과 나오는 정보들
    private String addressName;
    private String categoryGroupCode;
    private String categoryGroupName;
    private String categoryName;
    private String distance;
    private String id;
    private String phone;
    private String placeName;   // 프랜차이즈 이름이 포함되어 있는지 여부 비교
    private String placeUrl;
    private String roadAddressName;
    private String x;
    private String y;
}
