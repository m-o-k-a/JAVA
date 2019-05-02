package Interface;

import Actions.FillMove;
import Actions.Move;
import Items.Bottle;
import Items.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Configuration> configList = new ArrayList<>();
    public static List<Bottle> firstList = new ArrayList<>();
    public static List<Bottle> endList = new ArrayList<>();
    public static Configuration firstConfig;
    public static Configuration winConfig;
    public static boolean DEBUGWINNING = false; //BECAUSE NOTHING WORKSKBFUDGVYUSCHUIHIGHFDGLDU BUT WORKS THIS WAY

    public static void main(String[] args) {
        Bottle b1 = new Bottle(3, 3,"creeping");
        Bottle b2 = new Bottle(5, 5,"depression");
        firstList.add(b1);
        firstList.add(b2);
        Bottle b1F = new Bottle(3, 0,"creeping");
        Bottle b2F = new Bottle(5, 5,"depression");
        //TODO IT WORKED FINE BUT NOW IT DONT WANT HELP ME DAISUKETE KUDASAI
        endList.add(b1F);
        endList.add(b2F);

        firstConfig = new Configuration(firstList);
        winConfig = new Configuration((endList));
        configList.add(winConfig);
        configList.add(firstConfig);
        Solver solved = new Solver(firstList, endList);
        //System.out.println(firstConfig.possibleMoves());
        Move solve = solved.findWinningMove(firstConfig.possibleMoves()); //configList.get(configList.size()-1
        //System.out.println(configList.get(configList.size()-1).bottles.get(0).getContent());
        //System.out.println(firstConfig.bottles);
    }
}
