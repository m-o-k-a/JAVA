package neos.deserializeJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Distance {
    
  public double getAstronomical() {
    return astronomical;
  }

  public double getLunar() {
    return lunar;
  }

  public double getKilometers() {
    return kilometers;
  }

  @JsonProperty("astronomical")
  private double astronomical;
  @JsonProperty("lunar")
  private double lunar;
  @JsonProperty("kilometers")
  private double kilometers;

}
