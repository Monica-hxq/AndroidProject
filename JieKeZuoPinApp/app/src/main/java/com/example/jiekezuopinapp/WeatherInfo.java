package com.example.jiekezuopinapp;

public class WeatherInfo {

    /**
     * Id : 1
     * City : 郑州
     * Weather : 晴
     * WeatherBg : bz2.png
     * WeatherImg : sun.png
     * Temp : 32.2
     */

    private int Id;
    private String City;
    private String Weather;
    private String WeatherBg;
    private String WeatherImg;
    private double Temp;

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
