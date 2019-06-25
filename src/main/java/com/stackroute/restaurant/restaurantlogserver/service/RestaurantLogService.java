package com.stackroute.restaurant.restaurantlogserver.service;

import com.stackroute.restaurant.restaurantlogserver.domain.RestaurantLog;
import com.stackroute.restaurant.restaurantlogserver.exceptions.RestaurantIdAlreadyExistsException;

import java.util.List;

public interface RestaurantLogService {
    public RestaurantLog saveRestaurantLog(RestaurantLog restaurantLog) throws RestaurantIdAlreadyExistsException;
    public List<RestaurantLog> getAllRestaurantLog() throws Exception;
}
