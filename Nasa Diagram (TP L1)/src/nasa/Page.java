package nasa;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Page {

  private int size;

  @JsonProperty("total_elements")
  private int totalElements;

  @JsonProperty("total_pages")
  private int totalPages;

  private int number;

  public int getSize() {
    return size;
  }

  public int getTotalElements() {
    return totalElements;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public int getNumber() {
    return number;
  }
}
