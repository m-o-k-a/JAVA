package nasa;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrbitClass {

  @JsonProperty("orbit_class_type")
  private String orbitClassType;

  @JsonProperty("orbit_class_description")
  private String orbitClassDescription;

  @JsonProperty("orbit_class_range")
  private String orbitClassRange;

  public String getOrbitClassType() {
    return orbitClassType;
  }

  public String getOrbitClassDescription() {
    return orbitClassDescription;
  }

  public String getOrbitClassRange() {
    return orbitClassRange;
  }
}
