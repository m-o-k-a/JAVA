package classes;

import java.util.HashMap;
import java.util.Map;

public class Student {
    /**
     * @class Student
     * @param String name
     * @param Map grades
     */
    private final String name;
    private final Map<Course,Double> grades;

    /**
     * Student : constructor
     * @param name
     */
    public Student(String name) {
        this.name = name;
        this.grades = new HashMap<>();
    }

    /**
     * addGrade : add a grade for a given course
     * @param course
     * @param grade
     */
    public void addGrade(Course course, Double grade) {
        grades.put(course,grade);
    }

    /**
     * getGrade : return the grade of a given course
     * @param course
     * @return
     */
    public Double getGrade(Course course) {
        return grades.containsKey(course) ? grades.get(course) : 0.0;
    }

    /**
     * getScore : get the score of a given course
     * @param course
     * @return
     */
    public  double getScore(Course course) {
        return getGrade(course);
    }

    /**
     * getMeanScore : get the mean score of the student
     * @return
     */
    public double getMeanScore() {
        double meanScore = 0;
        for (Double grade : grades.values()) {
            meanScore += grade;
        }
        return meanScore/(grades.values().size());
    }
}
