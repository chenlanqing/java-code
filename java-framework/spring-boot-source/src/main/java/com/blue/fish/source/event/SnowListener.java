package com.blue.fish.source.event;

/**
 * @author bluefish 2020-01-12
 * @version 1.0.0
 */
public class SnowListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof SnowEvent) {
            System.out.println("hello " + event.getWeather());
        }
    }
}
