package com.stackroute.restaurant.restaurantlogserver.repository;
import com.stackroute.restaurant.restaurantlogserver.domain.RestaurantLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantLogRepository extends MongoRepository<RestaurantLog,Integer>{
}
