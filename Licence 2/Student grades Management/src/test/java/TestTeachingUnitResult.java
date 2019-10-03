import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestTeachingUnitResult {
  private static TeachingUnitResult twentyAtProg =
          new TeachingUnitResult("Programmation 2", TestGrade.twenty);
  private static TeachingUnitResult zeroAtStructDiscrete =
          new TeachingUnitResult("Structures discrètes", TestGrade.zero);

  @Test
  void testGetGrade() {
    assertEquals(TestGrade.twenty, twentyAtProg.getGrade());
    assertEquals(TestGrade.zero, zeroAtStructDiscrete.getGrade());
  }

  @Test
  void testToString() {
    assertEquals("Programmation 2 : 20.0/20", twentyAtProg.toString());
    assertEquals("Structures discrètes : 0.0/20", zeroAtStructDiscrete.toString());
  }
}
