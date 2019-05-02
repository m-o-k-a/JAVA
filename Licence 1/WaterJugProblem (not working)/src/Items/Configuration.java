package Items;
import Actions.EmptyMove;
import Actions.FillMove;
import Actions.Move;
import Actions.PourMove;
import Interface.Main;
import java.util.ArrayList;
import java.util.List;

public class Configuration {
    public List<Bottle> bottles;
    public Bottle selectedBottle;

    /**
     * Constructor: Take a list of bottle to initiate the configuration
     * @param bottles
     */
    public Configuration(List<Bottle> bottles) {
        this.bottles = bottles;
        Main.configList.add(this);
        selectBottle(bottles.get(0));
    }

    /**
     * Equals: test if a configuration is equal to another one
     * @param config
     * @return
     */
    public boolean equals(Configuration config) {
        if (this.bottles.size() == config.bottles.size()) {
            for (Bottle a : this.bottles) {
                for (Bottle b : config.bottles) {
                    if (!b.isEquals(a)) {
                        return false;
                    }
                }
            }return true;
        }return false;
    }

    public String getIndexName(Bottle bottle) {
        return bottle.getName();
    }
    public List<Bottle> getBottleList(){ return bottles; }

    /**
     * Select one bottle
     * @param bottle
     * @return
     */
    public void selectBottle(Bottle bottle) { this.selectedBottle = bottle; }

    /**
     * Return the bootle on which we do the action
     * @return
     */
    public Bottle activeBootle() {return this.selectedBottle; }
    public int indexBootle() {return bottles.indexOf(activeBootle()); }

    public List<Move> possibleMoves() {
        List<Move> possibleList = new ArrayList<>();
        Configuration active = (Main.configList.get(Main.configList.size()-1));
        for (int a = 0; a < bottles.size(); a++) {
            active.selectBottle(active.bottles.get(a));
            if (active.selectedBottle.isEmpty()) {
                Move toFill = new FillMove(a);
                possibleList.add(toFill);
            } else {
                Move toEmpty = new EmptyMove(a);
                possibleList.add(toEmpty);
            }
        }
        for (int b1 = 0; b1 < 2; b1++) {
            for (int b2 = 0; b2 < 2; b2++) { //
                for (int c = 0; c <= Main.firstConfig.bottles.get(b2).getContent(); c++) {
                    Move toPour = new PourMove(b1, b2, c);
                    if (!(b1 == b2)) {
                        possibleList.add(toPour);
                        //System.out.println(b1 + " " + b2 + " " + c);
                    }
                }
                //System.out.println("a");
            }
        }
        return possibleList;
    }

}