package com.Walmart.WalmartOrder;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "WalmartPayment")
public interface PaymentApp {

    @GetMapping("/api/payment")
    public String getPayment();

}
