package nasa;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrbitalData {

  public int getOrbitId() {
    return orbitId;
  }

  public LocalDateTime getOrbitDeterminationDate() {
    return orbitDeterminationDate;
  }

  public LocalDate getFirstObservationDate() {
    return firstObservationDate;
  }

  public LocalDate getLastObservationDate() {
    return lastObservationDate;
  }

  public int getDataArcInDays() {
    return dataArcInDays;
  }

  public int getObservationsUsed() {
    return observationsUsed;
  }

  public int getOrbitUncertainty() {
    return orbitUncertainty;
  }

  public double getMinimumOrbitIntersection() {
    return minimumOrbitIntersection;
  }

  public double getJupiterTisserandInvariant() {
    return jupiterTisserandInvariant;
  }

  public double getEpochOsculation() {
    return epochOsculation;
  }

  public double getEccentricity() {
    return eccentricity;
  }

  public double getSemiMajorAxis() {
    return semiMajorAxis;
  }

  public double getInclination() {
    return inclination;
  }

  public double getAscendingNodeLongitude() {
    return ascendingNodeLongitude;
  }

  public double getOrbitalPeriod() {
    return orbitalPeriod;
  }

  public double getPerihelionDistance() {
    return perihelionDistance;
  }

  public double getPerihelionArgument() {
    return perihelionArgument;
  }

  public double getAphelionDistance() {
    return aphelionDistance;
  }

  public double getPerihelionTime() {
    return perihelionTime;
  }

  public double getMeanAnomaly() {
    return meanAnomaly;
  }

  public double getMeanMotion() {
    return meanMotion;
  }

  public String getEquinox() {
    return equinox;
  }

  public OrbitClass getOrbitClass() {
    return orbitClass;
  }

  @JsonProperty("orbit_id")
  private int orbitId;

  @JsonProperty("orbit_determination_date")
  private LocalDateTime orbitDeterminationDate;

  @JsonProperty("first_observation_date")
  private LocalDate firstObservationDate;

  @JsonProperty("last_observation_date")
  private LocalDate lastObservationDate;

  @JsonProperty("data_arc_in_days")
  private int dataArcInDays;

  @JsonProperty("observations_used")
  private int observationsUsed;

  @JsonProperty("orbit_uncertainty")
  private int orbitUncertainty;

  @JsonProperty("minimum_orbit_intersection")
  private double minimumOrbitIntersection;

  @JsonProperty("jupiter_tisserand_invariant")
  private double jupiterTisserandInvariant;

  @JsonProperty("epoch_osculation")
  private double epochOsculation;

  private double eccentricity;

  @JsonProperty("semi_major_axis")
  private double semiMajorAxis;

  private double inclination;

  @JsonProperty("ascending_node_longitude")
  private double ascendingNodeLongitude;

  @JsonProperty("orbital_period")
  private double orbitalPeriod;

  @JsonProperty("perihelion_distance")
  private double perihelionDistance;

  @JsonProperty("perihelion_argument")
  private double perihelionArgument;

  @JsonProperty("aphelion_distance")
  private double aphelionDistance;

  @JsonProperty("perihelion_time")
  private double perihelionTime;

  @JsonProperty("mean_anomaly")
  private double meanAnomaly;

  @JsonProperty("mean_motion")
  private double meanMotion;

  private String equinox;

  @JsonProperty("orbit_class")
  private OrbitClass orbitClass;

}
