package com.stackroute.restaurant.restaurantlogserver.repository;

import com.stackroute.restaurant.restaurantlogserver.domain.RestaurantLog;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataMongoTest
public class RestaurantLogRepositoryTest {
    @Autowired
    private RestaurantLogRepository restaurantLogRepository;

    private RestaurantLog restaurantLog;
    @Before
    public void setUp() throws Exception {

        restaurantLog = new RestaurantLog();
        restaurantLog.setRestaurantlogid(23);
        restaurantLog.setFoodavailable(90);
        restaurantLog.setRating("5stsr");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//        SimpleDateFormat dateFormat=SimpleDateFormat(1212-09-11);
        String date = "2019-02-03 10:08:02";
        Date date1 = formatter.parse(date);
        restaurantLog.setLastUpdate(date1);
        restaurantLog.setStatus("yes");

    }

    @Test
    public void testgetAllRestaurantLog(){
        restaurantLogRepository.save(restaurantLog);
        List<RestaurantLog> list = restaurantLogRepository.findAll();
        System.out.println(list.get(0));
        Assert.assertEquals(12,list.get(0).getRestaurantlogid());

    }
}