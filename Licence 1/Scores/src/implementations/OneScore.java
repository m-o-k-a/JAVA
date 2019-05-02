package implementations;

import classes.Course;
import classes.Student;

public class OneScore {
    private String name = "Get One Score";
    private Course course;
    private double score;

    public OneScore(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public Double getScore(Student student) {
        return student.getGrade(course);
    }
}
