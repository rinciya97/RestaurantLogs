package com.stackroute.restaurant.restaurantlogserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantStatus {
    String username;
    int foodAvailability;
    String deliveryBoyName;
    int deliveryBoyMobileNo;
}
