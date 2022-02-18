package com.example.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class ServiceResponse {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callResponse_Fallback")
    public String callResponse(String ville) {

        String response = restTemplate
                .exchange("http://localhost:8080/weather/{ville}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, ville).getBody();

        return "this is my result : " + response;
    }

    @HystrixCommand(fallbackMethod = "callResponseByZipCode_Fallback")
    public String callResponseByZipCode(String zipCode) {

        String response = restTemplate
                .exchange("http://localhost:8080/weatherByZipCode/{zipCode}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, zipCode).getBody();

        return "this is my result : " + response;
    }

    @SuppressWarnings("unused")
    private String callResponse_Fallback(String ville) {
        System.out.println("Weather Service is down ...");
        return "Service indisponible pour le moment ! - " + new Date();
    }

    @SuppressWarnings("unused")
    private String callResponseByZipCode_Fallback(String ville) {
        System.out.println("Weather Service is down ...");
        return "Service indisponible pour le moment ! - " + new Date();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
