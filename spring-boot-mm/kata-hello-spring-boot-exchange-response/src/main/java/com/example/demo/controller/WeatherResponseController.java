package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// this is a Rest Controller
@RestController
public class WeatherResponseController {

    @Autowired
    ServiceResponse serviceResponse;

    @RequestMapping(value = "/show-weather/{ville}", method = RequestMethod.GET)
    public String getResponse(@PathVariable(value = "ville") String ville) {
        return serviceResponse.callResponse(ville);
    }

    @RequestMapping(value = "/show-weather-byZipCode/{zipCode}", method = RequestMethod.GET)
    public String getResponseByZipCode(@PathVariable(value = "zipCode") String zipCode) {
        return serviceResponse.callResponseByZipCode(zipCode);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getResponseTest() {
        return "test";
    }



}



