package com.centime.greetservice.service;

import com.centime.greetservice.entity.GreetingReq;
import com.centime.greetservice.entity.GreetingRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class GreetingService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${app.hello_service.ip}")
    private String helloServiceIp;

    @Value("${app.log_service.ip}")
    private String logServiceIp;

    /***
     * get greeting
     * @param greetingReq
     * @return
     */
    public GreetingRes getGreeting(GreetingReq greetingReq){
        log.info("Inside getGreeting of GreetingService");
        String helloMessage = null;
        String finalMessage = null;
        String fullName = null;
        try{
            helloMessage = restTemplate.getForObject(helloServiceIp+"/hello/say", String.class);
        }catch (org.springframework.web.client.ResourceAccessException e){
            log.error("Greeting service might be down", e);
            return new GreetingRes("Greeting service might be down", 404);
        }catch (Exception e){
            log.error("Something went wrong", e);
            return new GreetingRes("Something went wrong", 500);
        }

        try{
            fullName = restTemplate.postForObject(logServiceIp+"/log/concat", greetingReq, String.class);
        }catch (org.springframework.web.client.ResourceAccessException e){
            log.error("Concat service might be down", e);
            return new GreetingRes("Concat service might be down", 404);
        }catch (Exception e){
            log.error("Something went wrong", e);
            return new GreetingRes("Something went wrong", 500);
        }

        finalMessage = helloMessage + " "+fullName;
        GreetingRes greetingRes = new GreetingRes(finalMessage, 200);
        return greetingRes;
    }
}
