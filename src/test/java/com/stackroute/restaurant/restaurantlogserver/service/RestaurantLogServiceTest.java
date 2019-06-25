package com.stackroute.restaurant.restaurantlogserver.service;
import com.stackroute.restaurant.restaurantlogserver.domain.RestaurantLog;
import com.stackroute.restaurant.restaurantlogserver.exceptions.RestaurantIdAlreadyExistsException;
import com.stackroute.restaurant.restaurantlogserver.repository.RestaurantLogRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RestaurantLogServiceTest {
    private RestaurantLog restaurantLog;

    //Create a mock for UserRepository
    @Mock
    private RestaurantLogRepository restaurantLogRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private RestaurantLogServiceImpl restaurantLogServiceImpl;
    List<RestaurantLog> list= null;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        restaurantLog = new RestaurantLog();
        restaurantLog.setRestaurantlogid(7);
        restaurantLog.setFoodavailable(90);
        restaurantLog.setRating("5stsr");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String dateInString = "2019-02-03 10:08:02";
        Date date = formatter.parse(dateInString);
        restaurantLog.setLastUpdate(date);
        restaurantLog.setStatus("yes");
        list = new ArrayList();
        list.add(restaurantLog);

    }




    @Test
    public void saveRestaurantLog() throws RestaurantIdAlreadyExistsException {
        when(restaurantLogRepository.save((RestaurantLog) any())).thenReturn(restaurantLog);
        RestaurantLog savedrestaurantLog = restaurantLogServiceImpl.saveRestaurantLog(restaurantLog);
        Assert.assertEquals(restaurantLog,savedrestaurantLog);
        System.out.println(savedrestaurantLog);
        //verify here verifies that userRepository save method is only called once
        verify(restaurantLogRepository,times(1)).save(restaurantLog);
    }



    @Test(expected = RestaurantIdAlreadyExistsException.class)
    public void saveRestaurantLogTestFailure() throws RestaurantIdAlreadyExistsException {
        when(restaurantLogRepository.save((RestaurantLog) any())).thenReturn(null);
        RestaurantLog savedRestaurantLog = restaurantLogServiceImpl.saveRestaurantLog(restaurantLog);
        System.out.println("savedres"+savedRestaurantLog);
        Assert.assertEquals(restaurantLog,savedRestaurantLog);
    }


    @Test
    public void getAllRestaurantLog() throws Exception {
        restaurantLogRepository.save(restaurantLog);
        //stubbing the mock to return specific data
        when(restaurantLogRepository.findAll()).thenReturn(list);
        List<RestaurantLog> userlist = restaurantLogServiceImpl.getAllRestaurantLog();

        Assert.assertEquals(list,userlist);
    }
}