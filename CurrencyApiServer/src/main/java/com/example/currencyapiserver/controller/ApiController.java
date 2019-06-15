package com.example.currencyapiserver.controller;

import com.example.currencyapiserver.model.Rate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;



@RestController
public class ApiController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/rates")
    @HystrixCommand(fallbackMethod = "defaultNames")
    public String getNames(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8700/rates", HttpMethod.GET, entity, String.class).getBody();
    }

    public String defaultNames(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8800/rates", HttpMethod.GET, entity, String.class).getBody();
    }
}
