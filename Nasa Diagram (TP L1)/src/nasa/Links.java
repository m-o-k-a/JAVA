package nasa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Links {

    private String self ;
    private String next;
    private String prev;

    @JsonProperty("self")
    public String getSelf() { return self; }

    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    @JsonProperty("prev")
    public String getPrev() {
        return prev;
    }
}
