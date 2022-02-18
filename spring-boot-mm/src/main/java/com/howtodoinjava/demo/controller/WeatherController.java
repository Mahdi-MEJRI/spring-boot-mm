package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.howtodoinjava.demo.model.Weather;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Weather;

@RestController
public class WeatherController {

    static List<Weather> weatherList = new ArrayList<Weather>();
    static {
        weatherList.add(new Weather("Nice","06000","fr","16"));
        weatherList.add(new Weather("Marseille","09000","fr","13"));
        weatherList.add(new Weather("Rome","02000","it","10"));
        weatherList.add(new Weather("Milan","01000","it","11"));
        weatherList.add(new Weather("Barcelone","07000","es","15"));
        weatherList.add(new Weather("Madrid","04000","es","19"));
    }

    @RequestMapping("/weather")
    public List<Weather> getWeather()
    {
        return weatherList;
    }

    @RequestMapping(value = "/weather/{ville}")
    public Weather getWeather(@PathVariable(value = "ville") String ville) {
        return weatherList.stream().filter(x -> x.getVille().equalsIgnoreCase(ville)).collect(Collectors.toList()).get(0);
    }

    @RequestMapping(value = "/weatherByZipCode/{zipCode}")
    public Weather getWeatherByZipCode(@PathVariable(value = "zipCode") String zipCode) {
        return weatherList.stream().filter(x -> x.getZipCode().equalsIgnoreCase(zipCode)).collect(Collectors.toList()).get(0);
    }

    @RequestMapping(value = "/weatherByPays/{pays}")
    public List<Weather> getWeatherByPays(@PathVariable(value = "pays") String pays) {
        return weatherList.stream().filter(x -> x.getPays().equalsIgnoreCase(pays)).collect(Collectors.toList());
    }

}
