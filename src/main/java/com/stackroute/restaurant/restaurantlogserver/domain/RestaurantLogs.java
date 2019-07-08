//package com.stackroute.restaurant.restaurantlogserver.domain;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import java.util.Date;
//import java.util.List;
//
//@Document(collection="restaurantLogs")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class RestaurantLogs {
//    @Id
//    int restaurantlogid;
//    String userName;
//    String rating;
//    private List<RestaurantLogs> restaurantLogs;
//}
//
//
package com.stackroute.restaurant.restaurantlogserver.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection="restaurantLogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantLogs {
    @Id
    int restaurantlogid;
    String userName;
    RestaurantStatus restaurantStatus;
    String rating;
    String date;
}

