package implementations;

import classes.Student;
import interfaces.StudentScorer;

public class MeanScore implements StudentScorer {
    private String name = "Get Means Score";
    private double score;

    public String getName() {
        return name;
    }

    public Double getScore(Student student) {
        return student.getMeanScore();
    }
}
