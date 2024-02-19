package com.goodbap.breadboard.franchise.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.goodbap.breadboard.franchise.repository.FranchiseRepository;
import com.goodbap.breadboard.restaurant.domain.Restaurant;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class FranchiseService {
    private final FranchiseRepository repository;
    private ObjectMapper mapper = new ObjectMapper();

    public FranchiseService(FranchiseRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> franchiseFilter(List<Restaurant> restaurants) {
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = mapper.convertValue(restaurants.get(i), Restaurant.class);
            System.out.println(restaurant.getPlace_name());
            List<String> searchElement = new ArrayList<String>(Arrays.asList(restaurant.getPlace_name().split(" ")));
            for (String element : searchElement) {
                if (repository.findByBrandName(element).isPresent()) {
                    // System.out.println(restaurant);
                    restaurants.remove(i);
                }
            }
        }
        return restaurants;
    }

}
