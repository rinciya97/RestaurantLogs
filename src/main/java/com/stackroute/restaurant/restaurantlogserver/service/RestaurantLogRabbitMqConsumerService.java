package com.stackroute.restaurant.restaurantlogserver.service;
import com.stackroute.restaurant.restaurantlogserver.domain.Restaurant;
import com.stackroute.restaurant.restaurantlogserver.domain.RestaurantLogs;
import com.stackroute.restaurant.restaurantlogserver.domain.RestaurantStatus;
import com.stackroute.restaurant.restaurantlogserver.repository.RestaurantLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Component
@RabbitListener(queues = "${restaurantLogs.queue}")
public class RestaurantLogRabbitMqConsumerService {

     @Autowired
    RestaurantLogRepository restaurantLogRepository;

    @RabbitHandler
    public void recievedMessage(List<RestaurantStatus> restaurantStatusList) {
        List<Restaurant> restaurantList = restaurantLogRepository.findAll();
        for (int i = 0; i < restaurantStatusList.size(); i++) {
            RestaurantStatus restaurantStatus1 = restaurantStatusList.get(i);
            System.out.println("Recieved Message For Charity : " + restaurantStatus1.getUsername() + " => " + restaurantStatus1);
            Restaurant restaurant = restaurantLogRepository.getRestaurantByName(restaurantStatus1.getUsername());
            RestaurantLogs restaurantLogs = new RestaurantLogs();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            restaurantLogs.setRestaurantlogid(2);
            restaurantLogs.setDate(dtf.format(now));
            restaurantLogs.setRestaurantStatus(restaurantStatus1);
            restaurantLogs.setUserName(restaurantStatus1.getUsername());
            restaurantLogRepository.save(restaurant);
    }
}
}
