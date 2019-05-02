package classes;

import interfaces.StudentScorer;

import java.util.*;

public class Cohort implements Iterable<Student> {
    /**
     * @param set students
     **/
    private final Set<Student> students = new HashSet<>();

    /**
     * add : add a student to the cohort
     * @param student
     */
    public void add(Student student) {
        students.add(student);
    }

    /**
     * iterator : return a student list
     * @return
     */
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    /**
     * selectStudentValidating : Take the cohort student list and return the one who had more than 10 in a course
     * @param course
     * @return
     */
    public List<Student> selectStudentValidating(Course course) {
        List<Student> isPassed = new ArrayList<>();
        for(Student student : students) {
            if(student.getScore(course) >= 10) {
                isPassed.add(student);
            }
        }
        return isPassed;
    }

    /**
     * selectPassingStudents() : Take the cohort student list and return the one who had more than 10 in MeanScore
     * @return
     */
    public List<Student> selectPassingStudents() {
        List<Student> isPassed = new ArrayList<>();
        for(Student student: students) {
            if(student.getMeanScore() >= 10) {
                isPassed.add(student);
            }
        }
        return isPassed;
    }

    /**
     * selectStudentsByScore : Take the cohort student list and return the one who had more than requiredScore in a course
     * @param scorer
     * @param requiredScore
     * @return
     */
    public List<Student> selectStudentsByScore(StudentScorer scorer, double requiredScore) {
        List<Student> isGood = new ArrayList<>();
        for (Iterator<Student> it = students.iterator(); it.hasNext(); ) {
            Student student = it.next();
            if(scorer.getScore(student) >= requiredScore) {
                isGood.add(student);
            }
        }
        return isGood;
    }
}