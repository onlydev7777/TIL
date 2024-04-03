package com.study.chapter2;

import com.study.chapter2.observer.CurrentConditionsDisplay;
import com.study.chapter2.observer.ForecastDisplay;
import com.study.chapter2.observer.StatisticsDisplay;
import com.study.chapter2.subject.WeatherData;

public class WeatherStation {

  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();

    CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);
  }
}
