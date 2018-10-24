package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Coupon")
public class Coupon {
    @Id 
    @SequenceGenerator(name = "coupon_seq", sequenceName = "coupon_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_seq")
    private @NonNull Long Cid;
    private @NonNull String Code;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Discount.class)
    @JoinColumn(name = "CD_ID", insertable = true)
    private  Discount CouponDiscount;

   
    public Coupon(){}
    public Coupon(String QRcode){
        this.Code=Code;
    }
}