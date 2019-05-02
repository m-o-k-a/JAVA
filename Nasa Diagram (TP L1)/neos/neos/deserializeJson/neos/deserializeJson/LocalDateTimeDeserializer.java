package neos.deserializeJson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


// DO NOT MODIFY

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

  public LocalDateTimeDeserializer() {
    super(LocalDateTime.class);
  }

  private static final DateTimeFormatter formatter =
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Override
  public LocalDateTime deserialize(JsonParser jsonParser,
                                   DeserializationContext deserializationContext)
    throws IOException, JsonProcessingException
  {
    return LocalDateTime.parse(jsonParser.readValueAs(String.class), formatter);
  }
}
