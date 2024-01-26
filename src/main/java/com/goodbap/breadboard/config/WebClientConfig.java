package com.goodbap.breadboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient(){
    return WebClient.builder()
            .baseUrl("https://dapi.kakao.com/v2/local/search/category.json?")
      .defaultHeader("Authorization", "KakaoAK fc5df5456eb10cc9110d1f98fe36c815")
      .build();
  }
}
