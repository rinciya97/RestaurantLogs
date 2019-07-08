package com.stackroute.restaurant.restaurantlogserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    List<RestaurantLogs> restaurantLogs;
    String userName;
}
