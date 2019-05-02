package nasa;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

public class Document {

  private Links links;

  private Page page;

  @JsonProperty("near_earth_objects")
  private NearEarthObject[] nearEarthObjects;

  public List<NearEarthObject> getNearEarthObjects() {
    return Arrays.asList(nearEarthObjects);
  }

  public Page getPage() {
    return page;
  }

  public Links getLinks() {
    return links;
  }
}
