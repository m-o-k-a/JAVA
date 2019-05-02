package nasa;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Interval {

  @JsonProperty("estimated_diameter_min")
  private double estimatedDiameterMin;

  @JsonProperty("estimated_diameter_max")
  private double estimatedDiameterMax;

  public double getEstimatedDiameterMin() {
    return estimatedDiameterMin;
  }

  public double getEstimatedDiameterMax() {
    return estimatedDiameterMax;
  }
}
