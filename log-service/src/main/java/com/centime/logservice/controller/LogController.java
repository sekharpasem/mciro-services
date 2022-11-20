package com.centime.logservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/log")
public class LogController {

    /**
     * logs the payload and returns the combined the attribute values as string
     * @param payload
     * @return String
     */
    @PostMapping("/concat")
    public ResponseEntity<String> logAndConcat(@RequestBody HashMap<String, String> payload){
        log.info("Inside logAndConcat of LogController");
        log.info(payload.toString());
        try{
            String Name = payload.get("name");
            String Surname = payload.get("surname");
            String concatStr = Name+" "+Surname;
            return new ResponseEntity<String>(concatStr, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
