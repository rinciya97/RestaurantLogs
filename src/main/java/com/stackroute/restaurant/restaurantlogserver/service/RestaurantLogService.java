package com.stackroute.restaurant.restaurantlogserver.service;

import com.stackroute.restaurant.restaurantlogserver.domain.Restaurant;
//import com.stackroute.restaurant.restaurantlogserver.exceptions.RestaurantIdAlreadyExistsException;
//import com.stackroute.restaurant.restaurantlogserver.exceptions.RestaurantNameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantLogService {
    Restaurant saveRestaurantLog(Restaurant restaurant) throws Exception;
    List<Restaurant> getAllRestaurantLog() throws Exception;
    Restaurant getRestaurant(String username);

}
