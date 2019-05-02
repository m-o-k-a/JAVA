package Actions;

import Interface.Main;
import Items.Bottle;
import Items.Configuration;

import java.util.ArrayList;
import java.util.List;

public class PourMove implements Move {
    public int selectedBottles;
    public int receiver;
    public int moveValue = 0;
    public long value = 0;
    public int toPour = 0;
    public int index;
    public String nameValue;
    public List<Bottle> mineBottles = Main.configList.get(Main.configList.size()-1).bottles;

    /**
     * Constructor
     * @param selectedBottles
     */
    public PourMove(int selectedBottles, int receiver, int toPour) {//TODO POOR EVERYTHING ??? {
        this.selectedBottles = selectedBottles;
        this.receiver = receiver;
        this.toPour = toPour;
    }

    public void apply(Configuration configuration) {
        //UPDATE CONFIGURATION BECAUSE WE TAKE THE ID ON THE CALL
        configuration.selectedBottle = Main.firstConfig.bottles.get(selectedBottles);//configuration.bottles.get(selectedBottles);

        //recreate a bottle list
        List<Bottle> next = new ArrayList<>();
        for(Bottle nextBottle : configuration.bottles) {
            Bottle b = new Bottle(nextBottle.getMaxCapacity(), nextBottle.getContent(), nextBottle.getName());
            next.add(b);
        }
        //save the access of the other bottle in a temp variable
        for(Bottle other : next){
            if (other != configuration.selectedBottle) { index = next.indexOf(other); }
        }
        //create the new configuration
        Configuration nextConfig = new Configuration(next);
        //apply on the new configuration
        //int index = configuration.indexBootle();
        nextConfig.selectBottle(nextConfig.bottles.get(selectedBottles));
        //=======================================================================================================
        //begin the apply phase
        moveValue = 1;
        value = (nextConfig.selectedBottle).getMaxCapacity();
        nameValue = (nextConfig.selectedBottle).getName();
        (nextConfig.selectedBottle).transfer(nextConfig.selectedBottle,nextConfig.bottles.get(receiver), toPour);
        if ((nextConfig.selectedBottle.getContent() == Main.endList.get(selectedBottles).getContent()) && (nextConfig.bottles.get(receiver).getContent() == Main.endList.get(receiver).getContent())) { Main.DEBUGWINNING = true; display();}
    }

    public void reversedApply(Configuration configuration){ //DEBUG METHOD
        //UPDATE CONFIGURATION BECAUSE WE TAKE THE ID ON THE CALL
        configuration.selectedBottle = configuration.bottles.get(selectedBottles);

        for (Bottle n : configuration.bottles) { //THEY ARE TWO BOTTLES, THEREFORE...
            if (n != configuration.selectedBottle) { configuration.selectBottle(n); }
        }
        apply(configuration);
    }


    public void reverse(Configuration configuration) {
        //TRY ONE: JUST DELETE THE LATEST CONFIGURATION
        //Main.configList.remove(Main.configList.get(-1));
        //TRY TWO: REVERSE LATEST CONFIG AND LATEST-1
        int index = (Main.configList.indexOf(configuration));
        Configuration toReverse = Main.configList.get(index);
        Main.configList.set(index, Main.configList.get(index-1));
        Main.configList.set(index-1, toReverse);
    }
    public void display(){
        System.out.format("We pourred %d of water from %s to %s", toPour, mineBottles.get(selectedBottles), mineBottles.get(receiver));
    }
}
