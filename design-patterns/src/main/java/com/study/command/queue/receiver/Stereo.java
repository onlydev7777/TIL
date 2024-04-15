package com.study.command.queue.receiver;

public class Stereo {

  private String location;

  private String cd;
  private String dvd;
  private String radio;
  int volume;

  public Stereo(String location) {
    this.location = location;
  }

  public void on() {
    System.out.println("Stereo.on");
  }

  public void off() {
    System.out.println("Stereo.off");
  }

  public String getCd() {
    return cd;
  }

  public void setCd(String cd) {
    this.cd = cd;
    System.out.println("Stereo.setCd");
  }

  public String getDvd() {
    return dvd;
  }

  public void setDvd(String dvd) {
    this.dvd = dvd;
    System.out.println("Stereo.setDvd");
  }

  public String getRadio() {
    return radio;
  }

  public void setRadio(String radio) {
    this.radio = radio;
    System.out.println("Stereo.setRadio");
  }

  public int getVolume() {
    return volume;
  }

  public void setVolume(int volume) {
    this.volume = volume;
    System.out.println("Stereo.setVolume");
  }
}
