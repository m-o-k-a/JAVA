import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class TestStudent {
  private static Student arnaudLabourel = new Student("Arnaud", "Labourel");
  static Student paulCalcul = new Student("Paul", "Calcul");
  static Student pierreKiroul = new Student("Pierre", "Kiroul");

  @BeforeAll
  static void addResultsToStudents(){
    arnaudLabourel.addResult("Programmation 2", TestGrade.twenty);
    arnaudLabourel.addResult("Structures discrètes", TestGrade.twenty);
    pierreKiroul.addResult("Programmation 2", TestGrade.ten);
    pierreKiroul.addResult("Structures discrètes", TestGrade.zero);
    paulCalcul.addResult("Programmation 2", TestGrade.ten);
    paulCalcul.addResult("Structures discrètes", TestGrade.twenty);
  }

  @Test
  void testToString() {
    assertEquals("Paul Calcul", paulCalcul.toString());
    assertEquals("Pierre Kiroul", pierreKiroul.toString());
  }

  @Test
  void testGetGrades() {
    assertEquals(List.of(TestGrade.twenty, TestGrade.twenty), arnaudLabourel.getGrades());
    assertEquals(List.of(TestGrade.ten, TestGrade.zero), pierreKiroul.getGrades());
    assertEquals(List.of(TestGrade.ten, TestGrade.twenty), paulCalcul.getGrades());
  }

  @Test
  void testGetAverageGrade() {
    assertEquals(TestGrade.twenty, arnaudLabourel.averageGrade());
    assertEquals(new Grade(5), pierreKiroul.averageGrade());
    assertEquals(new Grade(15), paulCalcul.averageGrade());
  }

  @Test
  void testPrintResults() {
    StandardOutputSandbox standardOutputSandbox = new StandardOutputSandbox(() ->arnaudLabourel.printResults());
    String expectedOutput =
            "Arnaud Labourel" + StandardOutputSandbox.NEW_LINE
            + "Programmation 2 : 20.0/20" + StandardOutputSandbox.NEW_LINE
            + "Structures discrètes : 20.0/20" + StandardOutputSandbox.NEW_LINE
            + "Note moyenne : 20.0/20" + StandardOutputSandbox.NEW_LINE;
    standardOutputSandbox.run();
    assertEquals(expectedOutput, standardOutputSandbox.getProducedOutput());
  }
}