package com.example.demo_1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class MainController {

    @GetMapping("/sum/{number1}/{number2}")
    @ResponseBody
    public String sumTwoNumbers(@PathVariable int number1, @PathVariable int number2) {
        int result = number1 + number2;
        return "The sum of " + number1 + " and " + number2 + " is " + result;
    }

    @GetMapping("/sub/{number1}/{number2}")
    @ResponseBody
    public String subTwoNumbers(@PathVariable int number1, @PathVariable int number2) {
        int result = number1 - number2;
        return "The sub of " + number1 + " and " + number2 + " is " + result;
    }

    @GetMapping("/mul/{number1}/{number2}")
    @ResponseBody
    public String mulTwoNumbers(@PathVariable int number1, @PathVariable int number2) {
        int result = number1 * number2;
        return "The mul of " + number1 + " and " + number2 + " is " + result;
    }

    @GetMapping("/div/{number1}/{number2}")
     public String divTwoNumbers(@PathVariable int number1, @PathVariable int number2) {
        int result = number1 % number2;
        return "The div of " + number1 + " and " + number2 + " is " + result;
    }

}
