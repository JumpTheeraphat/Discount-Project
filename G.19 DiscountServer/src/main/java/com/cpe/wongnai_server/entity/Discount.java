package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Discount")
public class Discount {
    @Id 
    @SequenceGenerator(name = "discount_seq", sequenceName = "discount_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_seq")
    private @NonNull Long Id;
    private @NonNull String Name;
    private @NonNull String Title;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Restaurant.class)
    @JoinColumn(name = "DR_ID", insertable = true)
    private  Restaurant DiscountRestaurant;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "DCG_ID", insertable = true)
    private  Category DiscountCategory;
   
    public Discount() {}

    public Discount(String Name,String Title,String Pic) {
        this.Name = Name;
        this.Title = Title;
    }
}