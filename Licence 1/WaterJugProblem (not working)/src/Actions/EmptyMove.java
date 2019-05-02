package Actions;

import Interface.Main;
import Items.Bottle;
import Items.Configuration;

import java.util.ArrayList;
import java.util.List;

public class EmptyMove implements Move {
    public int selectedBottles;
    public int moveValue = 0;
    public long value = 0;
    public String nameValue;
    public int otherone;

    /**
     * Constructor
     * @param selectedBottles
     */
    public EmptyMove(int  selectedBottles) {
        this.selectedBottles = selectedBottles;
        //TODO BECAUSDE OF BUG
        if (selectedBottles == 0) { otherone = 1; }
        if (selectedBottles == 1) { otherone = 0; }
    }

    public void apply(Configuration configuration){
        //UPDATE CONFIGURATION BECAUSE WE TAKE THE ID ON THE CALL
        configuration.selectedBottle = configuration.bottles.get(selectedBottles);

        //recreate a bottle list
        List<Bottle> next = new ArrayList<>();
        for(Bottle nextBottle : configuration.bottles) {
            Bottle b = new Bottle(nextBottle.getMaxCapacity(), nextBottle.getContent(), nextBottle.getName());
            next.add(b);
        }
        //create the new configuration
        Configuration nextConfig = new Configuration(next);
        //apply on the new configuration
        //int index = configuration.indexBootle();
        nextConfig.selectBottle(nextConfig.bottles.get(configuration.indexBootle()));
        //=======================================================================================================
        //begin the apply phase
        moveValue = 1;
        //value = (nextConfig.selectedBottle).getMaxCapacity();
        //nameValue = (nextConfig.selectedBottle).getName();
        nameValue = nextConfig.selectedBottle.getName();
        (nextConfig.selectedBottle).emptyBottle();
        if (nextConfig.selectedBottle.getContent() == Main.endList.get(selectedBottles).getContent()) {
            if (Main.firstList.get(otherone).getContent() == Main.endList.get(otherone).getContent()) {
                Main.DEBUGWINNING = true; display();
            }
        }
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
        System.out.format("Empty %s", nameValue);
    }
}
