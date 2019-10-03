import java.util.ArrayList;
import java.util.List;

/**
 * A group of students.
 */

public class Cohort {
  private final String name;
  private final List<Student> students;

  /**
   * Constructs a cohort with a name equals to the specified {@code name} and no students.
   * @param name the name of the constructed Cohort
   */

  public Cohort(String name) {
    this.name = name;
    this.students = new ArrayList<>();
  }

  /**
   * Add the specified {@code student} to the students of the cohort.
   * @param student the student to be added to the cohort
   */
  public void addStudent(Student student){
    students.add(student);
  }

  /**
   * Returns the list of students of the cohort.
   * @return the list of students of the cohort.
   */
  public List<Student> getStudents(){
    return students;
  }

  /**
   * Print via the standard output the name of the cohort and all results associated to the students with their average
   * grade.
   */
  public void printStudentsResults(){
    System.out.println(toString());
    System.out.println();
    for(Student student : getStudents()) {
      student.printResults();
      System.out.println();
    }
  }

    /**
     * Returns the amount of student who passed
     * @return the amount of student who passed
     */
  public int countStudentsWhoPassed() {
    int count = 0;
    for (Student student : getStudents()) {
      if (Double.valueOf(student.averageGrade().getValue()) >= 10) { count++; }
    }
    return  count;
  }

    /**
     * Returns the amount of student who absent
     * @return the amount of student who absent
     */
  public int countStudentsWhoAbsent() {
      int count = 0;
      for (Student student : getStudents()){
          for(Grade grades : student.getGrades()) {
              if (grades.getValue() == "ABS") { count++; continue; }
          }
      }
      return count;
  }

    /**
     * Returns the maximum grade
     * @return the maximum grade
     */
  public Double maxGrade() {
      double grade = 0;
      for (Student student : getStudents()) {
          if (Double.valueOf(student.averageGrade().getValue()) > grade) {
              grade = Double.valueOf(student.averageGrade().getValue());
          }
      }
      return grade;
  }

    /**
     * Returns the minimum grade
     * @return the minimum grade
     */
    public Double minGrade() {
        double grade = Double.valueOf(students.get(0).averageGrade().getValue());
        for (Student student : getStudents()) {
            if (Double.valueOf(student.averageGrade().getValue()) < grade) {
                grade = Double.valueOf(student.averageGrade().getValue());
            }
        }
        return grade;
    }


  /**
   * Returns the name of the cohort.
   * @return the name of the cohort
   */
  @Override
  public String toString() {
    return name;
  }
}
