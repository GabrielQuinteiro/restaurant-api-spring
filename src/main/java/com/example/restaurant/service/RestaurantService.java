package com.example.restaurant.service;

import com.example.restaurant.model.Restaurant;

public interface RestaurantService {
    Restaurant findById(Long id);

    Restaurant create(Restaurant restaurantToCreate);
}
