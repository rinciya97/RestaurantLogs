package com.stackroute.restaurant.restaurantlogserver.exceptions;

public class RestaurantIdAlreadyExistsException extends Throwable {
    private String message;
    public RestaurantIdAlreadyExistsException(){
    }
    public RestaurantIdAlreadyExistsException(String message)
    {
        super(message);
        this.message=message;
    }
}
