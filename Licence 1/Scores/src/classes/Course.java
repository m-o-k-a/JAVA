package classes;

public class Course {
    /**
     * CLASS COURSE
     * @param String name
     */

    private final String name;

    /**
     * Course : constructor
     * @param name
     */
    public Course(String name) {
        this.name = name;
    }

    /**
     * GetName : return the name of the course
     * @return
     */
    public String getName() {
        return name;
    }
}