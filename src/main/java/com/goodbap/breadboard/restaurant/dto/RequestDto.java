package com.goodbap.breadboard.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestDto {
    String latitude;
    String longitude;
    String radius;
}
