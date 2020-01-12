package com.blue.fish.source.event;

/**
 * @author bluefish 2020-01-12
 * @version 1.0.0
 */
public class RainEvent extends WeatherEvent {
    @Override
    public String getWeather() {
        return "Rain Weather";
    }
}
