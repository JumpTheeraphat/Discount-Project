package com.cpe.wongnai_server.Controller;
import org.springframework.web.bind.annotation.*;
import com.cpe.wongnai_server.Repository.*;
import com.cpe.wongnai_server.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class RestaurantController{
    @Autowired
    private RestaurantRepository repository;
    
    @GetMapping("/Restaurant")
    public List<Restaurant> showAllRestaurant(){
        return repository.findAll().stream().collect(Collectors.toList());
    }
}