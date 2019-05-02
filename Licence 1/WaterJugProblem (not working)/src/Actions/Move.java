package Actions;
import Items.Bottle;
import Items.Configuration;

public interface Move {
    void apply(Configuration configuration);
    void reversedApply(Configuration configuration);
    void reverse(Configuration configuration);
    void display();
}
