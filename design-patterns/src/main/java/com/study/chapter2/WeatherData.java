package com.study.chapter2;

import java.util.Random;

public class WeatherData {

  public float getTemperature() {
    return new Random().nextFloat();
  }

  public float getHumidity() {
    return new Random().nextFloat();
  }

  public float getPressure() {
    return new Random().nextFloat();
  }

  //기상 관측 값이 갱신 될 때 마다 디스플레이에 알려줘야 하는 메서드
  public void measurementsChanged() {
    float temperature = getTemperature();
    float humidity = getHumidity();
    float pressure = getPressure();

    //currentConditionDisplay.update(temp,humidity,pressure);
    //statisticsDisplay.update(temp,humidity,pressure);
    //forecastDisplay.update(temp,humidity,pressure);
  }
}
