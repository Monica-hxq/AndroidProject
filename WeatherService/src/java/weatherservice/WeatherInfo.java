/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import java.io.Serializable;

/**
 *用于和json交互
 * @author Administrator
 */
public class WeatherInfo implements Serializable{
    private int Id;
    private String City;
    private String Weather;
    private String WeatherBg;
    private String WeatherImg;
    private double Temp;

    public WeatherInfo() {
    }

    public WeatherInfo(int Id, String City, String Weather, String WeatherBg, String WeatherImg, double Temp) {
        this.Id = Id;
        this.City = City;
        this.Weather = Weather;
        this.WeatherBg = WeatherBg;
        this.WeatherImg = WeatherImg;
        this.Temp = Temp;
    }



    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String Weather) {
        this.Weather = Weather;
    }

    public String getWeatherBg() {
        return WeatherBg;
    }

    public void setWeatherBg(String WeatherBg) {
        this.WeatherBg = WeatherBg;
    }

    public String getWeatherImg() {
        return WeatherImg;
    }

    public void setWeatherImg(String WeatherImg) {
        this.WeatherImg = WeatherImg;
    }

    public double getTemp() {
        return Temp;
    }

    public void setTemp(double Temp) {
        this.Temp = Temp;
    }
    
}
