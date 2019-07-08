package com.stackroute.restaurant.restaurantlogserver.repository;
import com.stackroute.restaurant.restaurantlogserver.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantLogRepository extends MongoRepository<Restaurant,String>{
    @Query("{ 'userName' : ?0 },{}")
    Restaurant getRestaurantByName(String userName);
}
