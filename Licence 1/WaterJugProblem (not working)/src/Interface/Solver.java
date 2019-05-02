package Interface;

import Actions.Move;
import Items.Bottle;
import Items.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    public List<Configuration> configList = Main.configList;
    public List<Bottle> initialBottles = new ArrayList<>();
    public List<Bottle> victoryBottles = new ArrayList<>();
    public Configuration initialConfiguration;
    public Configuration winningConfiguration;

    public Solver(List<Bottle> initialBottles, List<Bottle> victoryBottles) {
        this.initialBottles = initialBottles;
        this.victoryBottles = victoryBottles;
        Configuration initialConfiguration = new Configuration(initialBottles);
        winningConfiguration = new Configuration(victoryBottles);
        configList.add(initialConfiguration);
        //System.out.println(initialBottles);
    }

    public Boolean isWinningMove(Move move) { //FILLMOVE EMPTYMOVE POURMOVE
        move.apply(Main.configList.get(1)); //will add the new move
        Bottle selected = Main.configList.get(Main.configList.size()-2).selectedBottle;
        Bottle winning = Main.configList.get(Main.configList.size()-1).selectedBottle;
        //TODO I TRY TO MAKE THAT WORK
        Bottle c1 = Main.firstConfig.bottles.get(0);//Main.configList.get(Main.configList.size()-1).bottles.get(0);
        Bottle c2 = Main.firstConfig.bottles.get(1);//Main.configList.get(Main.configList.size()-1).bottles.get(1);
        Bottle c3 = Main.winConfig.bottles.get(0);
        Bottle c4 = Main.winConfig.bottles.get(1);
        //System.out.println("b1: " + c1.getContent() + "(Expected: " + c3.getContent() + ") || b2: " + c2.getContent() + "(Expected: " + c4.getContent() + ")");
        //TODO: REPAIR MY IS EQUALS
        //TODO: I NEED TO COMPARE ONLY THE CONTENT BECAUSE AFTER IT WILL DONT WORK FOR NO REASON (solved)
        //TODO: - don't work if we need to just empty or fill the second bottle -that pourmove (solved)
        //TODO: example for emptymove, the list<move> show that it exist but just do like if it doesn't (solved)
        //TODO: because it don't go trought the second bottle of the list (solved)
        //TODO: NOW IT JUST ALWAYS THINK THZAT B1 IS FILL EVEN IF ITS EMPTY (solved but with a loss)
        //TODO: SO I HAVE TO ALWAYS TOOK THE INITIAL CONFIGURATION, THEREFORE I AM STUCK TO ONLY DO ONE ACTION, CAN'T DO MORE
        //TODO: SOLVE POURMOVE (WORK BUT EVEN IF WE EDIT THE OBJECT VALUE IT WILL SAY WRONG EVEN IF THE POUR WORKED ;-;

        //TODO: worked fine the 24/03, I surely touched something because now it never work ;-;
        //if(winningConfiguration.bottles.get(0).getContent() == Main.configList.get(Main.configList.size()-1).bottles.get(0).getContent()) {
        if (c1.getContent() == c3.getContent() && c2.getContent() == c4.getContent()) { // I have to only check the content to avoid theses null pointers who come from idk where
            move.display();

            //move.reverse(Main.configList.get(Main.con;
            //move.reverse(Main.configList.get(Main.configList.size()-1));
            //Main.configList.remove(Main.configList.size()-1);
            return true;
        }
        if (Main.DEBUGWINNING) { return true; } //BECAUSE I HAD AN ERROR
        return false;
    }

    public Move findWinningMove(List<Move> move){
        System.out.println(move);
        for(Move testMoves : move) {
            //System.out.println(testMoves);
            //System.out.println(isWinningMove(testMoves));
            System.out.println("Testing Move: " + testMoves);
            if(isWinningMove(testMoves)) {
                //System.out.println(testMoves);
                return testMoves;
            }
        }
        System.out.println("Can't solve");
        return null;
    }

}
