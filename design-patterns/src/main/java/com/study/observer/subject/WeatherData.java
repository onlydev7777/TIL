package com.study.observer.subject;

import com.study.observer.observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

  private List<Observer> observers = new ArrayList<>();
  private float temperature;
  private float humidity;
  private float pressure;

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    observers.remove(o);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(temperature, humidity, pressure);
    }
  }

  //기상 관측 값이 갱신 될 때 마다 디스플레이에 알려줘야 하는 메서드
  public void measurementsChanged() {
    notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }
}
