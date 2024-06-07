package _02_structual_patterns._07_bridge._02_after;

import _02_structual_patterns._07_bridge._01_before.Champion;

public class App {

  public static void main(String[] args) {
    Champion kda아리 = new KDA아리(new KDA());
    kda아리.skillQ();
    kda아리.skillW();

    Champion poolParty아칼리 = new PoolParty아칼리(new PoolParty());
    poolParty아칼리.skillR();
    poolParty아칼리.skillW();
  }
}
