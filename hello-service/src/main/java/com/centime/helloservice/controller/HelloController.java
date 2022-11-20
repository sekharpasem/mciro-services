/**
 * @author Sekhar
 */

package com.centime.helloservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Hello Controller
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    /**
     * API to get greeting message
     * @return
     */
    @GetMapping("/say")
    public ResponseEntity<String> sayHello(){
        log.info("Inside sayHello of HelloController");
        String message = "Hello";
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
