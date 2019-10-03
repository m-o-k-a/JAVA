import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCohort {
  private static Cohort cohort = new Cohort("L2 informatique");

  @BeforeAll
  static void addStudentsToCohort(){
    Student paulCalcul = new Student("Paul", "Calcul");
    Student pierreKiroul = new Student("Pierre", "Kiroul");
    pierreKiroul.addResult("Programmation 2", TestGrade.ten);
    pierreKiroul.addResult("Structures discrètes", TestGrade.zero);
    paulCalcul.addResult("Programmation 2", TestGrade.ten);
    paulCalcul.addResult("Structures discrètes", TestGrade.twenty);
    cohort.addStudent(paulCalcul);
    cohort.addStudent(pierreKiroul);
  }

  @Test
  void testGetStudents(){
    assertEquals(List.of(TestStudent.paulCalcul, TestStudent.pierreKiroul), cohort.getStudents());
  }

  @Test
  void testPrintStudentsResults() {
    StandardOutputSandbox standardOutputSandbox = new StandardOutputSandbox(() ->cohort.printStudentsResults());
    String expectedOutput = "L2 informatique" + StandardOutputSandbox.NEW_LINE + StandardOutputSandbox.NEW_LINE
            + "Paul Calcul" + StandardOutputSandbox.NEW_LINE
            + "Programmation 2 : 10.0/20" + StandardOutputSandbox.NEW_LINE
            + "Structures discrètes : 20.0/20" + StandardOutputSandbox.NEW_LINE
            + "Note moyenne : 15.0/20" + StandardOutputSandbox.NEW_LINE + StandardOutputSandbox.NEW_LINE
            + "Pierre Kiroul" + StandardOutputSandbox.NEW_LINE
            + "Programmation 2 : 10.0/20" + StandardOutputSandbox.NEW_LINE
            + "Structures discrètes : 0.0/20" + StandardOutputSandbox.NEW_LINE
            + "Note moyenne : 5.0/20" + StandardOutputSandbox.NEW_LINE + StandardOutputSandbox.NEW_LINE;
    standardOutputSandbox.run();
    assertEquals(expectedOutput, standardOutputSandbox.getProducedOutput());
  }
}
