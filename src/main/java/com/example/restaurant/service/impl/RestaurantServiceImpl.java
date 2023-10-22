package com.example.restaurant.service.impl;

import com.example.restaurant.model.Restaurant;
import com.example.restaurant.repository.RestaurantRepository;
import com.example.restaurant.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Restaurant create(Restaurant restaurantToCreate) {
        if (restaurantRepository.existsByName(restaurantToCreate.getName())) {
            throw new IllegalArgumentException("This Restaurant already exists.");
        }
        return restaurantRepository.save(restaurantToCreate);
    }
}
