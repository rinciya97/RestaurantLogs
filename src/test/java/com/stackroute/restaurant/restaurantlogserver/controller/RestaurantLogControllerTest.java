package com.stackroute.restaurant.restaurantlogserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.restaurant.restaurantlogserver.domain.RestaurantLog;
import com.stackroute.restaurant.restaurantlogserver.exceptions.RestaurantIdAlreadyExistsException;
import com.stackroute.restaurant.restaurantlogserver.service.RestaurantLogService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RestaurantLogControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private RestaurantLog restaurantLog;
    @MockBean
    private RestaurantLogService restaurantLogService;
    @InjectMocks
    private RestaurantLogController restaurantLogController;

    private List<RestaurantLog> list =null;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);//to initialise annotated fields

        // Setup Spring test in standalone mode
        mockMvc = MockMvcBuilders.standaloneSetup(restaurantLogController).build();
        restaurantLog = new RestaurantLog();
        restaurantLog.setRestaurantlogid(23);
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
    public void saveRestaurantLog() throws RestaurantIdAlreadyExistsException, Exception {
        //any-any parameters
        when(restaurantLogService.saveRestaurantLog(any())).thenReturn(restaurantLog);
        //post method
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/restaurant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(restaurantLog)))//convert the object to json string
                .andExpect(MockMvcResultMatchers.status().isCreated())//expections
                .andDo(MockMvcResultHandlers.print());//printing it
    }
    @Test
    public void saveRestaurantLogFailure() throws RestaurantIdAlreadyExistsException, Exception {
        when(restaurantLogService.saveRestaurantLog(any())).thenThrow(RestaurantIdAlreadyExistsException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/restaurant")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurantLog)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void getAllRestaurantLogs() throws Exception {
        when(restaurantLogService.getAllRestaurantLog()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/restaurant")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurantLog)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}