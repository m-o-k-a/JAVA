import java.rmi.UnexpectedException;

public class Main {
    public static void main(String[] args) {
        Student eunsun = new Student("YUN", "eunsun");
        Student eddy = new Student("IKHLEF", "eddy");

        eunsun.addResult("Programmation 2", new Grade(20.));
        eunsun.addResult("Structures discretes",new Grade(20.));
        eddy.addResult("Programmation 2", new Grade("20"));
        eddy.addResult("Structures discretes",new Grade("20"));

        Cohort promotion = new Cohort("L2 informatique");

        promotion.addStudent(eunsun);
        promotion.addStudent(eddy);

        promotion.printStudentsResults();
    }
}
