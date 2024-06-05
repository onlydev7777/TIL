package _04_builder._02_after;

import _04_builder._01_before.TourPlan;

public class App {

  public static void main(String[] args) {
    TourDirector tourDirector = new TourDirector(new DefaultTourPlanBuilder());
    TourPlan cancunTrip = tourDirector.cancunTrip();
    TourPlan longBeachTrip = tourDirector.longBeachTrip();
    System.out.println("cancunTrip = " + cancunTrip);
    System.out.println("longBeachTrip = " + longBeachTrip);
  }
}
