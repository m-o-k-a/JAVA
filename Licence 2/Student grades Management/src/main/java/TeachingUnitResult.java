/**
 * A result corresponding to a grade associated with a teaching unit.
 */

public class TeachingUnitResult {
  private final String teachingUnitName;
  private final Grade grade;


  /**
   * Constructs an instance of TeachingUnitResult with a grade equals to the specified {@code grade}
   * and a teaching unit name equals to the specified {@code teachingUnitName}.
   *
   * @param teachingUnitName the name of the teaching unit of the constructed TeachingUnitResult
   * @param grade the grade of the constructed TeachingUnitResult
   */

  public TeachingUnitResult(String teachingUnitName, Grade grade) {
    this.teachingUnitName = teachingUnitName;
    this.grade = grade;
  }

  /**
   * Returns the grade associated to the result.
   *
   * @return the grade associated to the result
   */
  public Grade getGrade() {
    return grade;
  }

  /**
   * Returns a string representation of the result in the format Name of the teaching unit : X.X.
   * @return a string representation of the result
   */
  @Override
  public String toString() {
    return teachingUnitName + " : " + grade.toString();
  }


  /**
   * Determines whether or not two results are equal. Two instances of TeachingUnitResult are equal if the values
   * of their {@code teachingUnitName} and {@code grade} member fields are the same.
   * @param o  an object to be compared with this TeachingUnitResult
   * @return {@code true} if the object to be compared is an instance of TeachingUnitResult and has the same grad and
   * teaching unit name; {@code false} otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TeachingUnitResult that = (TeachingUnitResult) o;

    if (!teachingUnitName.equals(that.teachingUnitName)) return false;
    return grade.equals(that.grade);
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int result = teachingUnitName.hashCode();
    result = 31 * result + grade.hashCode();
    return result;
  }
}
