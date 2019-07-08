package com.stackroute.restaurant.restaurantlogserver.service;
import com.stackroute.restaurant.restaurantlogserver.domain.Restaurant;
import com.stackroute.restaurant.restaurantlogserver.repository.RestaurantLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantLogServiceImpl implements RestaurantLogService {
    @Autowired
    RestaurantLogRepository restaurantLogRepository;

    @Autowired
    public RestaurantLogServiceImpl(RestaurantLogRepository restaurantLogRepository) {
        this.restaurantLogRepository = restaurantLogRepository;
    }

    @Override
    public Restaurant saveRestaurantLog(Restaurant restaurant) throws Exception {
        if (restaurantLogRepository.existsById(restaurant.getUserName())) {
            throw new Exception("Restaurant already exists");
        } else
            return restaurantLogRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurantLog() throws Exception {
        List<Restaurant> log = restaurantLogRepository.findAll();
        return log;
    }
    @Override
    public Restaurant getRestaurant(String username)
    {
        return restaurantLogRepository.getRestaurantByName(username);
    }

    //    @Override
//    public Restaurant getRestaurantByName(String username) {
//        return restaurantLogRepository.getRestaurantByName(username);
//    }
//


    //@Override
//public RestaurantLogs saveRestaurantLog(RestaurantLogs restaurantLogs) throws RestaurantIdAlreadyExistsException{
//    if(restaurantLogRepository.existsById(restaurantLogs.getRestaurantlogid()))
    {
//        throw new RestaurantIdAlreadyExistsException("RestaurantID already exists exception");
//    }
//    RestaurantLogs savedrestaurantLog =restaurantLogRepository.save(restaurantLogs);
//    if(savedrestaurantLog ==null)
//    {
//        throw new RestaurantIdAlreadyExistsException("RestaurantID already exist exception");
//    }
//
//    return savedrestaurantLog;
//}

//    @Override
//    public List<Restaurant> getAllRestaurantLog() throws Exception {
//
//        List<Restaurant> log = restaurantLogRepository.findAll();
//        return log;
//    }
//
//    @Override
//    public boolean deleteRestaurantLog(String restaurantName) throws Exception {
//        boolean status=false;
//        if(restaurantLogRepository.existsById(restaurantName))
//        {
//            restaurantLogRepository.deleteById(restaurantName);
//            status=true;
//            return status;
//        }
//        else{
//            throw new Exception("Restaurant not found");
//        }
//    }


//    @Override
//    public List<RestaurantLogs> getRestaurantByName(String restaurantName) throws RestaurantNameNotFoundException {
//        List<RestaurantLogs> listOfRestaurants = null;
//        listOfRestaurants= restaurantLogRepository.getRestaurantByName(restaurantName);
//        if (listOfRestaurants.isEmpty())
//        {
//            throw new RestaurantNameNotFoundException("Restaurant Name Not Found");
//        }
//        return listOfRestaurants;
//    }
    }
}