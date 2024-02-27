package com.goodbap.breadboard.restaurant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.goodbap.breadboard.franchise.service.FranchiseService;
import com.goodbap.breadboard.restaurant.domain.Restaurant;
import com.goodbap.breadboard.restaurant.dto.CoordRequestDto;
import com.goodbap.breadboard.restaurant.dto.KeywordRequestDto;
import com.goodbap.breadboard.restaurant.resource.Meta;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.ErrorResponseException;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
        private final FranchiseService service;
        private WebClient webClient;

        public RestaurantService(FranchiseService service, WebClient webClient) {
                this.service = service;
                this.webClient = webClient;
        }

        public List<Restaurant> getRestaurantsByCoord(CoordRequestDto dto) throws ErrorResponseException {
                List<Restaurant> restaurantList = new ArrayList<Restaurant>();
                for (int page = 1; page <= 45; page++) {
                        String pageStr = Integer.toString(page);
                        Map<String, Object> response = webClient.get()
                                        .uri("https://dapi.kakao.com/v2/local/search/category.json",uriBuilder -> uriBuilder
                                                        .queryParam("category_group_code", "FD6")
                                                        .queryParam("page", pageStr)
                                                        .queryParam("y", dto.getLatitude())
                                                        .queryParam("x", dto.getLongitude())
                                                        .queryParam("radius", dto.getRadius())
                                                        .build())
                                        .retrieve()
                                        .bodyToMono(Map.class)
                                        .block();
                        restaurantList.addAll((List<Restaurant>) response.get("documents"));
                        ObjectMapper mapper = new ObjectMapper();
                        Meta resultMeta = mapper.convertValue(response.get("meta"), Meta.class);
                        if (resultMeta.getIs_end().equals("true")) {
                                break;
                        }
                }
                return getFilteredRestaurants(restaurantList);
        }

        public List<Restaurant> getRestaurantsBykeyword(KeywordRequestDto dto) throws ErrorResponseException {
                List<Restaurant> restaurantList = new ArrayList<Restaurant>();
                for (int page = 1; page <= 45; page++) {
                        String pageStr = Integer.toString(page);
                        Map<String, Object> response = webClient.get()
                                        .uri("https://dapi.kakao.com/v2/local/search/keyword.json", uriBuilder -> uriBuilder
                                                        .queryParam("category_group_code", "FD6")
                                                        .queryParam("page", pageStr)
                                                        .queryParam("query", dto.getKeyword())
                                                        .build())
                                        .retrieve()
                                        .bodyToMono(Map.class)
                                        .block();
                        restaurantList.addAll((List<Restaurant>) response.get("documents"));
                        ObjectMapper mapper = new ObjectMapper();
                        Meta resultMeta = mapper.convertValue(response.get("meta"), Meta.class);
                        if (resultMeta.getIs_end().equals("true")) {
                                break;
                        }
                }
                return getFilteredRestaurants(restaurantList);
        }

        public List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants) {
                return service.franchiseFilter(restaurants);
        }
}
