package com.stackroute.restaurant.restaurantlogserver.service;

import com.stackroute.restaurant.restaurantlogserver.domain.RestaurantLog;

import java.util.List;

public interface RestaurantLogService {
    public RestaurantLog saveRestaurantLog(RestaurantLog restaurantLog) throws Exception;
    public List<RestaurantLog> getAllRestaurantLog() throws Exception;
}
