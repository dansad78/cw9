package com.example.sheduledcurrencyserver.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@EnableScheduling
public class ShedullerController {
    @Scheduled(cron =  "0 0 11 * * *")
    @Scheduled(cron = "0 0 14 * * *")
    @Scheduled(cron = "0 30 17 * * *")
    public void sayHello(){

        RestTemplate restTemplate = new RestTemplate();

        String s = restTemplate.getForObject("http://localhost:8800/rates", String.class, new HashMap());

        ResponseEntity<String> save = restTemplate.exchange(
                "http://localhost:8800/init",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>(){});

    }
}
}
