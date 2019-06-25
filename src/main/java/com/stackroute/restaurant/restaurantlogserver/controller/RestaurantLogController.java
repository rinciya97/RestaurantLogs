package com.stackroute.restaurant.restaurantlogserver.controller;

import com.stackroute.restaurant.restaurantlogserver.domain.RestaurantLog;
import com.stackroute.restaurant.restaurantlogserver.exceptions.RestaurantIdAlreadyExistsException;
import com.stackroute.restaurant.restaurantlogserver.service.RestaurantLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class RestaurantLogController {
    RestaurantLogService restaurantLogService;
    public RestaurantLogController(RestaurantLogService restaurantLogService)
    {
        this.restaurantLogService = restaurantLogService;
    }
    @PostMapping("restaurant")
    public ResponseEntity<?> saveRestaurantLog(@RequestBody RestaurantLog restaurantLog) {
        ResponseEntity responseEntity;
        try
        {
            restaurantLogService.saveRestaurantLog(restaurantLog);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }
        catch (RestaurantIdAlreadyExistsException ex)
        {

            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

        }
        return responseEntity;
    }
    @GetMapping("restaurant")
    public ResponseEntity<?> getAllRestaurantLogs() throws Exception {
        return new ResponseEntity<List<RestaurantLog>>(restaurantLogService.getAllRestaurantLog(),HttpStatus.OK);
    }
}
