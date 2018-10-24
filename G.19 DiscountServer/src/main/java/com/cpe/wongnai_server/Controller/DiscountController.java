package com.cpe.wongnai_server.Controller;
import org.springframework.web.bind.annotation.*;
import com.cpe.wongnai_server.Repository.*;
import com.cpe.wongnai_server.entity.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.JodaTimeConverters.DateTimeToDateConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ch.qos.logback.classic.Logger;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import javax.validation.constraints.Null;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
class DiscountController{
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private PeriodRepository periodRepository;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    
    @GetMapping("/Discount")
    public List<Discount> showAllDiscount(){
        return discountRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/Discountbyid/{id}")
    public Discount ShowDiscountdetail(@PathVariable Long id) {
        Optional<Discount> discount = discountRepository.findById(id);
        return discount.get();
    }

    @GetMapping("/Timebyid/{Pid}")
    public Period ShowTime(@PathVariable Long Pid) {
        Optional<Period> period = periodRepository.findById(Pid);
        return period.get();
    }

    
    @PostMapping("/discount/create/{Name}/{Title}/{Tid}")
    public Discount createDiscount(@PathVariable String Name,@PathVariable String Title,@PathVariable long Tid){

        Discount discount = new Discount();
        
        discount.setName(Name);
        discount.setTitle(Title);
        discount.setDiscountCategory(categoryRepository.getOne(Tid));
        return discountRepository.save(discount);

    }

    @PostMapping("/period/create/{Sdate}/{Edate}/{Duration}")
    public Period createPeriod(@PathVariable String Sdate,@PathVariable String Edate,@PathVariable String Duration){

        Period period = new Period();

        period.setEdate(Edate);
        period.setSdate(Sdate);
        period.setDuration(Duration);
        
        
        return periodRepository.save(period);

    }
    @PostMapping("/coupon/create/{code}")
    public Coupon createCoupon(@PathVariable String code) {

        Coupon coupon = new Coupon();
        coupon.setCode(code);
        return couponRepository.save(coupon);

    }

    
    

   
    
}