package com.stackroute.restaurant.restaurantlogserver.controller;
import com.stackroute.restaurant.restaurantlogserver.domain.Restaurant;
import com.stackroute.restaurant.restaurantlogserver.service.RestaurantLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1")
public class RestaurantLogController {
    @Autowired
    RestaurantLogService restaurantLogService;

    @Autowired
    public RestaurantLogController(RestaurantLogService restaurantLogService) {
        this.restaurantLogService = restaurantLogService;
    }
    @PostMapping("restaurant")
    public ResponseEntity<?> saveRestaurantLog(@RequestBody Restaurant restaurant) throws Exception
    {
        ResponseEntity responseEntity;
        restaurantLogService.saveRestaurantLog(restaurant);
        responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        System.out.println("Restaurant : "+ restaurant);
        return  responseEntity;
    }

    @GetMapping("restaurant")
    public ResponseEntity getRestaurantLogs(@RequestParam String username)
    {
        return  new ResponseEntity(restaurantLogService.getRestaurant(username),HttpStatus.OK);
    }

//    @PostMapping("restaurant")
//    public ResponseEntity<?> saveRestaurantLog(@RequestBody RestaurantLogs restaurantLogs) {
//        ResponseEntity responseEntity;
//        try
//        {
//            restaurantLogService.saveRestaurantLog(restaurantLogs);
//            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
//            System.out.println("post"+restaurantLogs);
//        }
//        catch (RestaurantIdAlreadyExistsException ex)
//        {
//
//            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
//
//        }
//        return responseEntity;
//    }


//    @GetMapping("restaurant")
//    public ResponseEntity<?> getAllRestaurantLogs() throws Exception {
//        return new ResponseEntity<List<RestaurantLogs>>(restaurantLogService.getAllRestaurantLog(), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/restaurant/{restaurantName}")
//    public ResponseEntity<?> deleteRestaurantLog(@PathVariable("restaurantName") int restaurantName) throws Exception {
//        ResponseEntity responseEntity;
//        try {
//            restaurantLogService.deleteRestaurantLog(restaurantName);
//            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.CREATED);
//        } catch (Exception ex) {
//            //responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
//            throw ex;
//        }
//        return responseEntity;
//    }
//
//    @GetMapping("/restaurant/{restaurantName}")
//    public ResponseEntity<List<RestaurantLogs>> getRestaurantByName(@PathVariable("restaurantName") String track) {
//        ResponseEntity responseEntity;
//        try {
//            List<RestaurantLogs> trackList = restaurantLogService.getRestaurantByName(track);
//            return new ResponseEntity<List<RestaurantLogs>>(trackList, HttpStatus.OK);
//        } catch (RestaurantNameNotFoundException ex) {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//            ex.getMessage();
//        }
//        return responseEntity;
//    }

}

