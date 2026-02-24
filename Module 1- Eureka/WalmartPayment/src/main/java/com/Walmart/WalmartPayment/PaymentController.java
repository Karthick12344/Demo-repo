package com.Walmart.WalmartPayment;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @GetMapping("/payment")

    public String getPayment()
    {
        return "Hello from Payment";
    }

}
