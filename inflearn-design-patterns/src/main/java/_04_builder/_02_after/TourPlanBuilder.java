package _04_builder._02_after;

import _04_builder._01_before.TourPlan;
import java.time.LocalDate;

public interface TourPlanBuilder {

  TourPlanBuilder newInstance();

  TourPlanBuilder title(String title);

  TourPlanBuilder nightsAndDays(int nights, int days);

  TourPlanBuilder startDate(LocalDate startDate);

  TourPlanBuilder whereToStay(String whereToStay);

  TourPlanBuilder addPlan(int day, String plan);

  TourPlan getPlan();
}
