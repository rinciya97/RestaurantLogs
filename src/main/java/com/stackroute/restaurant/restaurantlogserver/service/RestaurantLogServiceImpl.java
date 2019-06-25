package com.stackroute.restaurant.restaurantlogserver.service;

import com.stackroute.restaurant.restaurantlogserver.domain.RestaurantLog;
import com.stackroute.restaurant.restaurantlogserver.exceptions.RestaurantIdAlreadyExistsException;
import com.stackroute.restaurant.restaurantlogserver.repository.RestaurantLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantLogServiceImpl implements RestaurantLogService {
    RestaurantLogRepository restaurantLogRepository;

    @Autowired
    public RestaurantLogServiceImpl(RestaurantLogRepository restaurantLogRepository)
    {
        this.restaurantLogRepository=restaurantLogRepository;
    }
    @Override
    public RestaurantLog saveRestaurantLog(RestaurantLog restaurantLog) throws RestaurantIdAlreadyExistsException{
        if(restaurantLogRepository.existsById(restaurantLog.getRestaurantlogid()))
        {
            throw new RestaurantIdAlreadyExistsException("RestaurantID already exists exception");
        }
        RestaurantLog savedrestaurantLog =restaurantLogRepository.save(restaurantLog);
        if(savedrestaurantLog ==null)
        {
            throw new RestaurantIdAlreadyExistsException("RestaurantID already exist exception");
        }

        return savedrestaurantLog;
    }

    @Override
    public List<RestaurantLog> getAllRestaurantLog() throws Exception {
        return restaurantLogRepository.findAll();
    }
}
