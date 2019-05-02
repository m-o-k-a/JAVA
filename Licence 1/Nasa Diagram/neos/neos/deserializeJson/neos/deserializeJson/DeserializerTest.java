package neos.deserializeJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DeserializerTest {

  public URL fetchJson(String resourceName) {
    return DeserializerTest.class.getResource(resourceName);
  }

  public final ObjectMapper mapper = new ObjectMapper();

  public DeserializerTest() {
    SimpleModule module = new SimpleModule();
    module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
    module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
    mapper.registerModule(module);
  }


  @Test
  public void testLinks() throws IOException {
    Links links =
      mapper.readValue(fetchJson("resources/links.json"), Links.class);
    //mapper.readValue(fetchJson("resources/output.json"), Links.class);
    String self = "https://api.nasa.gov/neo/rest/v1/neo/browse?page=1&size=20&api_key=myRandomKey";
    String next = "https://api.nasa.gov/neo/rest/v1/neo/browse?page=2&size=20&api_key=myRandomKey";
    String prev = "https://api.nasa.gov/neo/rest/v1/neo/browse?page=0&size=20&api_key=myRandomKey";
    assertEquals(self, links.getSelf());
    assertEquals(next, links.getNext());
    assertEquals(prev, links.getPrev());
  }

  @Test
  public void testVelocity() throws IOException {
    Velocity velocity =
      mapper.readValue(fetchJson("resources/relative_velocity.json"), Velocity.class);
    assertEquals(14772.3907366372, velocity.getKilometersPerHour(), 1e-9); //TODO ERROR BUT GOOD VALUES
    assertEquals(4.1034418713, velocity.getKilometersPerSecond(), 1e-9); //TODO ERROR BUT GOOD VALUES
  }


  @Test
  public void testDistance() throws IOException {
    Distance distance =
      mapper.readValue(fetchJson("resources/miss_distance.json"), Distance.class);
    assertEquals(48738264, distance.getKilometers(), 1e-3);
    assertEquals(0.3257951697, distance.getAstronomical(), 1e-6);
    assertEquals(126.7343215942, distance.getLunar(), 1e-9);
  }

  @Test
  public void testCloseApproachData() throws IOException {
    Approach approach =
      mapper.readValue(fetchJson("resources/close_approach_data.json"), Approach.class);
    LocalDate date = LocalDate.of(1994, 8, 21);
    assertEquals(date, approach.getCloseApproachDate());
    assertEquals(777452400000L, approach.getEpochDateCloseApproach());
    assertEquals(48738264, approach.getMissDistance().getKilometers());
    assertEquals(14772.3907366372, approach.getRelativeVelocity().getKilometersPerHour(), 1e-9);
    assertEquals("Earth", approach.getOrbitingBody());
  }


  @Test
  public void testDiameter() throws IOException {
    Diameter diameter =
      mapper.readValue(fetchJson("resources/estimated_diameter.json"), Diameter.class);
    assertEquals(231.5021222103, diameter.getMetersMin(), 1e-6);
    assertEquals(517.6544821978, diameter.getMetersMax(), 1e-6);
    assertEquals(0.2315021222, diameter.getKilometersMin(), 1e-9);
    assertEquals(0.5176544822, diameter.getKilometersMax(), 1e-9);
  }


  @Test
  public void testOrbitClass() throws IOException {
    OrbitClass orbit =
      mapper.readValue(fetchJson("resources/orbit_class.json"), OrbitClass.class);
    assertEquals(
      "Near-Earth asteroid orbits similar to that of 1221 Amor",
      orbit.getOrbitClassDescription()
    );
    assertEquals(
      "1.017 AU < q (perihelion) < 1.3 AU",
      orbit.getOrbitClassRange()
    );
    assertEquals("AMO", orbit.getOrbitClassType());
  }


  @Test
  public void testPage() throws IOException {
    Page page =
      mapper.readValue(fetchJson("resources/page.json"), Page.class);
    assertEquals(1, page.getNumber());
    assertEquals(20, page.getSize());
    assertEquals(20542,page.getTotalElements());
    assertEquals(1028,page.getTotalPages());
  }

  @Test
  public void testOrbitData() throws IOException {
    OrbitalData orbit =
      mapper.readValue(fetchJson("resources/orbital_data.json"), OrbitalData.class);
    assertEquals(4.017066577488577, orbit.getAphelionDistance(),1e-9);
    assertEquals(200.9095563635586, orbit.getAscendingNodeLongitude(), 1e-9);
    assertEquals(18, orbit.getDataArcInDays());
    assertEquals(.5267311176088368, orbit.getEccentricity(),1e-9);
    assertEquals(2458600.5, orbit.getEpochOsculation(),1e-3);
    assertEquals("J2000", orbit.getEquinox());
    assertEquals(LocalDate.of(1994,10,9), orbit.getFirstObservationDate());
    assertEquals(7.01725043161831, orbit.getInclination(),1e-9);
    assertEquals(3.177, orbit.getJupiterTisserandInvariant(),1e-6);
    assertEquals(LocalDate.of(1994,10,27), orbit.getLastObservationDate());
    assertEquals(281.8522530425884, orbit.getMeanAnomaly(), 1e-9);
    assertEquals( .230932132267039, orbit.getMeanMotion(), 1e-9);
    assertEquals(.260198, orbit.getMinimumOrbitIntersection(), 1e-9);
    assertEquals(27, orbit.getObservationsUsed());
    assertEquals(1558.899562680662, orbit.getOrbitalPeriod(),1e-6);
    assertEquals(
      LocalDateTime.of(2017,4,6,9,18,13),
      orbit.getOrbitDeterminationDate()
    );
    assertEquals(12, orbit.getOrbitId());
    assertEquals(7, orbit.getOrbitUncertainty());
    assertEquals(119.2787798944603, orbit.getPerihelionArgument(),1e-9);
    assertEquals(1.245243899002003, orbit.getPerihelionDistance(),1e-9);
    assertEquals(2458938.901357101078, orbit.getPerihelionTime(),1e-3);
    assertEquals(2.63115523824529, orbit.getSemiMajorAxis(),1e-9);
    assertEquals(
      "1.017 AU < q (perihelion) < 1.3 AU",
      orbit.getOrbitClass().getOrbitClassRange()
    );
  }

  @Test
  public void testNearEarthObject() throws IOException {
    NearEarthObject neo =
      mapper.readValue(fetchJson("resources/near_earth_object.json"), NearEarthObject.class);
    assertEquals(20.3, neo.getAbsoluteMagnitudeH(), 1e-6);
    assertEquals(777452400000L , neo.getCloseApproachData().get(0).getEpochDateCloseApproach());
    assertEquals("1994 TA2", neo.getDesignation());
    assertEquals(0.5176544822, neo.getEstimatedDiameter().getKilometersMax(),1e-9);
    assertEquals(
      "https://api.nasa.gov/neo/rest/v1/neo/3092128?api_key=myRandomKey",
      neo.getLinks().getSelf()
    );
    assertEquals("(1994 TA2)", neo.getName());
    assertEquals("http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3092128", neo.getNasaJplUrl());
    assertEquals("3092128", neo.getNeoReferenceId());
    assertEquals(12, neo.getOrbitalData().getOrbitId());
  }

  @Test
  public void TestDoc() throws IOException {
    Document doc = mapper.readValue(fetchJson("resources/doc.json"), Document.class);
    assertEquals(3, doc.getNearEarthObjects().size());
    assertEquals(1, doc.getPage().getNumber());
    assertEquals(
      "https://api.nasa.gov/neo/rest/v1/neo/browse?page=1&size=20&api_key=myRandomKey",
      doc.getLinks().getSelf()
    );
  }
}