package com.goodbap.breadboard.restaurant.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@JsonIgnoreProperties({"same_name"})
public class Meta {
    private String is_end;
    private String total_count;
    private String pageable_count;
    private String same_came;
}
