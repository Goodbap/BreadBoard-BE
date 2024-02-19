package com.goodbap.breadboard.restaurant.webConfig;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Configuration
public class WebConfig {
    @Value("${kakao-api-key}")
    String kakao_api_key;
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://dapi.kakao.com/v2/local/search/category.json")
                .defaultHeader("Authorization", "KakaoAK " + kakao_api_key)
                .build();
    }
}
