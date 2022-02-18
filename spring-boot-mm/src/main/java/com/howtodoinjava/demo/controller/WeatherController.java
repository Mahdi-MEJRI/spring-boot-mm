package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.howtodoinjava.demo.model.Weather;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Weather;

@Api(value="WeatherController", description = "REST Apis pour la meteo !")
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

    @ApiOperation(value = "Get list of weather in towns", response = Iterable.class, tags = "getWeather")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping("/weather")
    public List<Weather> getWeather()
    {
        return weatherList;
    }

    @ApiOperation(value = "Get weather in specefic tow ", response = Weather.class, tags = "getWeatherInTown")
    @RequestMapping(value = "/weather/{ville}")
    public Weather getWeather(@PathVariable(value = "ville") String ville) {
        return weatherList.stream().filter(x -> x.getVille().equalsIgnoreCase(ville)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get specific Student in the System ", response = Weather.class, tags = "getWeatherByZipCode")
    @RequestMapping(value = "/weatherByZipCode/{zipCode}")
    public Weather getWeatherByZipCode(@PathVariable(value = "zipCode") String zipCode) {
        return weatherList.stream().filter(x -> x.getZipCode().equalsIgnoreCase(zipCode)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get list of weather by country", response = Iterable.class, tags = "getWeatherBycountry")
    @RequestMapping(value = "/weatherByPays/{pays}")
    public List<Weather> getWeatherByPays(@PathVariable(value = "pays") String pays) {
        return weatherList.stream().filter(x -> x.getPays().equalsIgnoreCase(pays)).collect(Collectors.toList());
    }

}
