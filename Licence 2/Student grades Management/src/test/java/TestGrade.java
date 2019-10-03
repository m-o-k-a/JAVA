import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class TestGrade {
  static Grade twenty = new Grade(20);
  static Grade zero = new Grade(0);
  static Grade ten = new Grade(10);
  private static List<Grade> grades = List.of(zero, twenty, ten);
  private static List<Grade> gradesZero = List.of(zero, zero);

  @Test
  void testGetValue() {
    assertEquals("20.0", twenty.getValue());
    assertEquals("0.0", zero.getValue());
  }

  @Test
  void testToString() {
    assertEquals("20.0/20", twenty.toString());
    assertEquals("0.0/20", zero.toString());
  }

  @Test
  void testAverageGrade(){
    assertEquals(ten, Grade.averageGrade(grades));
    assertEquals(zero, Grade.averageGrade(gradesZero));
  }
}
