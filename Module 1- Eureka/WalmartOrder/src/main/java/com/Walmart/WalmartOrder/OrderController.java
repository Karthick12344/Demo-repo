package com.Walmart.WalmartOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order")

        public String getOrder()
        {
            String response = restTemplate.getForObject("http://WalmartPayment/api/payment",String.class);
            return "Order service is up and running " +response;

          //  return "Order service is up and running";
        }


}
