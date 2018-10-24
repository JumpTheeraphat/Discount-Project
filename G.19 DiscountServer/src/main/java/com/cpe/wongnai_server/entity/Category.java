package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Category")
public class Category {    
    @Id 
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    private @NonNull Long Tid;
    private @NonNull String Type;

    public Category(){}
    public Category(String Type){
        this.Type=Type;
    }
}