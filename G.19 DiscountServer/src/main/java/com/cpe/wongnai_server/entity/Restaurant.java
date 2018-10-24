package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Restaurants")
public class Restaurant {
    @Id 
    @SequenceGenerator(name = "restaurant_seq", sequenceName = "restaurant_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    private @NonNull Long Rid;
    private @NonNull String restaurantName;

    public Restaurant() {}

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}