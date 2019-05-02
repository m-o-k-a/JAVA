package neos.deserializeJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Velocity {

    @JsonProperty("kilometers_per_hour")
    private double kilometersPerHour;

    @JsonProperty("kilometers_per_second")
    private double kilometersPerSeconds;

    public double getKilometersPerHour() {
        return kilometersPerHour;
    }

    public double getKilometersPerSecond() {
        return kilometersPerSeconds;
    }
    
}
