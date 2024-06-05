package _04_builder._02_after;

import _04_builder._01_before.DetailPlan;
import _04_builder._01_before.TourPlan;
import java.time.LocalDate;
import java.util.List;

public class DefaultTourPlanBuilder implements TourPlanBuilder {

  private TourPlan tourPlan;

  @Override
  public TourPlanBuilder newInstance() {
    this.tourPlan = new TourPlan();
    return this;
  }

  @Override
  public TourPlanBuilder title(String title) {
    this.tourPlan.setTitle(title);
    return this;
  }

  @Override
  public TourPlanBuilder nightsAndDays(int nights, int days) {
    this.tourPlan.setNights(nights);
    this.tourPlan.setDays(days);
    return this;
  }

  @Override
  public TourPlanBuilder startDate(LocalDate startDate) {
    this.tourPlan.setStartDate(startDate);
    return this;
  }

  @Override
  public TourPlanBuilder whereToStay(String whereToStay) {
    this.tourPlan.setWhereToStay(whereToStay);
    return this;
  }

  @Override
  public TourPlanBuilder addPlan(int day, String plan) {
    List<DetailPlan> plans = this.tourPlan.getPlans();
    plans.add(new DetailPlan(day, plan));
    return this;
  }

  @Override
  public TourPlan getPlan() {
    return this.tourPlan;
  }
}
