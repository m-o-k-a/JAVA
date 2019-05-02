package neos.deserializeJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import nasa.Distance;
import nasa.Velocity;

import java.time.LocalDate;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Approach {

  @JsonProperty("close_approach_date")
  private LocalDate approachdate;
  @JsonProperty("epoch_date_close_approach")
  private long epochDateCloseApproach;
  @JsonProperty("relative_velocity")
  private Velocity relativeVelocity;
  @JsonProperty("miss_distance")
  private Distance missDistance;
  @JsonProperty("orbiting_body")
  private String orbitingBody;
  @JsonProperty("kilometersPerHour")
  private double kilometersPerHour;

  public LocalDate getCloseApproachDate() {
    return approachdate;
  }

  public long getEpochDateCloseApproach() {
    return epochDateCloseApproach;
  }

  public Velocity getRelativeVelocity() {
    return relativeVelocity;
  }

  public Distance getMissDistance() {
    return missDistance;
  }

  public String getOrbitingBody() {
    return orbitingBody;
  }

  public double getKilometersPerHour() { return kilometersPerHour;}


}
