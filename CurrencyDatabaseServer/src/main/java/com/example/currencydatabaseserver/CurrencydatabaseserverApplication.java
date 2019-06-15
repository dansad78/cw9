package com.example.currencydatabaseserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CurrencydatabaseserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencydatabaseserverApplication.class, args);
    }

}
