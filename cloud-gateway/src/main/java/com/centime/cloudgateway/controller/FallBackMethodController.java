package com.centime.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/greetServiceFallBack")
    public String greetServiceFallBackMethod(){
        return "Greet Service is taking longer than expected. Please try again later";
    }
    @GetMapping("/helloServiceFallBack")
    public String helloServiceFallBackMethod(){
        return "Hello Service is taking longer than expected. Please try again later";
    }
    @GetMapping("/logServiceFallBack")
    public String logServiceFallBackMethod(){
        return "Log Service is taking longer than expected. Please try again later";
    }

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service is taking longer than expected. Please try again later";
    }
}
