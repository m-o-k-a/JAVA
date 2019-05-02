package interfaces;

import classes.Student;

public interface StudentScorer {
    /**
     * interface of scores
     **/

    String getName();
    Double getScore(Student student);
}
