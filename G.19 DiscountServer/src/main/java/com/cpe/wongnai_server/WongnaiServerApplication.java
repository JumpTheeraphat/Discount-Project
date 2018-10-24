package com.cpe.wongnai_server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cpe.wongnai_server.entity.*;
import com.cpe.wongnai_server.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.stream.Stream;

@SpringBootApplication
public class WongnaiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WongnaiServerApplication.class, args);
	}
	@Bean
	ApplicationRunner init(CategoryRepository categoryRepository, CouponRepository couponRepository,
		DiscountRepository discountRepository, PeriodRepository periodRepository,RestaurantRepository restaurantRepository) {
        return args -> {
            
            Stream.of( "percent","amount","code" ,"other").forEach(Type -> {
                Category category = new Category();
                category.setType(Type);
                categoryRepository.save(category);
            });
            Stream.of("moom bar", "ake ga mai").forEach(restaurantName -> {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantName(restaurantName);
                restaurantRepository.save(restaurant);
            });
            Stream.of("buy one get one","50% off!").forEach(Name -> {
                Discount discount = new Discount();
                //Period period = new Period();
                discount.setName(Name);
                /*period.setSdate(01 01 1998);
                period.setEdate(01 01 1998);                
                periodRepository.save(period);*/
                discountRepository.save(discount);
                
                if (Name == "buy one get one") {
                    discount.setTitle("purchase 1 get free 1");
                    discount.setDiscountCategory(categoryRepository.getOne(4L));
                    discount.setDiscountRestaurant(restaurantRepository.getOne(1L));
                    discountRepository.save(discount);
                } 
                if (Name == "50% off!") {
                    discount.setTitle("you can buy product in half price");
                    discount.setDiscountCategory(categoryRepository.getOne(1L));
                    discount.setDiscountRestaurant(restaurantRepository.getOne(2L));
                    discountRepository.save(discount);
                } 
            });
            Stream.of("ABC", "XYZ").forEach(code -> {
                Coupon coupon = new Coupon();
                coupon.setCode(code);
                couponRepository.save(coupon);
                if (code == "ABC") {
                    coupon.setCouponDiscount(discountRepository.getOne(1L));
                    couponRepository.save(coupon);
                } 
                if (code == "XYZ") {
                    coupon.setCouponDiscount(discountRepository.getOne(2L));
                    couponRepository.save(coupon);
                } 
            });
            couponRepository.findAll().forEach(System.out::println);
            categoryRepository.findAll().forEach(System.out::println);
            restaurantRepository.findAll().forEach(System.out::println);
            discountRepository.findAll().forEach(System.out::println);
        };
    }
}
