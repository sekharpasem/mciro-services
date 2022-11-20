package com.centime.greetservice.controller;

import com.centime.greetservice.entity.GreetingReq;
import com.centime.greetservice.entity.GreetingRes;
import com.centime.greetservice.service.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Greeting APIs
 */
@RestController
@Slf4j
@RequestMapping("/greets")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    /**
     * Is service up?
     * @return
     */
    @GetMapping
    public ResponseEntity<String> serviceIsUp(){
        log.info("Inside serviceIsUp of GreetingController");
        return new ResponseEntity<String>("Up", HttpStatus.OK);
    }
    /**
     * gets greeting message
     * @param greetingReq
     * @return
     */
    @PostMapping("/me")
    public ResponseEntity<GreetingRes> getGreetingMessage(@RequestBody GreetingReq greetingReq){
        log.info("Inside getGreetingMessage of GreetingController");
        try{
            GreetingRes greetingRes= greetingService.getGreeting(greetingReq);
            return new ResponseEntity<GreetingRes>(greetingRes, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<GreetingRes>(new GreetingRes("Something went wrong!", 500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
