package com.howtodoinjava.demo.model;

import io.swagger.annotations.ApiModelProperty;

public class Weather {

    @ApiModelProperty(notes = "Nom ville",name="ville",required=true,value="test ville")
    private String ville;
    @ApiModelProperty(notes = "Code postal",name="zipCode",required=true,value="test zipCode")
    private String zipCode;
    @ApiModelProperty(notes = "Nom pays",name="pays",required=true,value="test pays")
    private String pays;
    @ApiModelProperty(notes = "Temperature dans la ville",name="meteo",required=true,value="test meteo")
    private String meteo;


    public Weather(String ville, String zipCode, String pays, String meteo) {
        this.ville = ville;
        this.zipCode = zipCode;
        this.pays = pays;
        this.meteo = meteo;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "ville='" + ville + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", pays='" + pays + '\'' +
                ", meteo='" + meteo + '\'' +
                '}';
    }
}
