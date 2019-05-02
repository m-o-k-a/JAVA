package Items;

import Actions.EmptyMove;
import Interface.Main;

public class Bottle {

    private final long MAX_BOTTLE_CAPACITY;
    private long CONTENT;
    private final String name;

    public Bottle(long capacity, long content, String name){
        this.MAX_BOTTLE_CAPACITY = capacity;
        this.CONTENT = content;
        this.name = name;
    }

    public long getMaxCapacity(){ return MAX_BOTTLE_CAPACITY; }
    public long getContent(){ return CONTENT; }

    public boolean isEmpty(){
        if (this.CONTENT == 0){
            return true;
        } return false;

    }

    public boolean isFull() {
        if (this.CONTENT == MAX_BOTTLE_CAPACITY) {
            return true;
        }
        return false;
    }

    public void emptyBottle(){
        this.CONTENT = 0;
    }
    public void fillBottle(){
        this.CONTENT = MAX_BOTTLE_CAPACITY;
    }
    public boolean isEquals(Bottle a) {
        return (this.name == a.name && this.CONTENT == a.CONTENT && this.MAX_BOTTLE_CAPACITY == a.MAX_BOTTLE_CAPACITY);
    }
    public String getName() {
        return this.name;
    }


    public void transfer(Bottle bottleOne, Bottle bottleTwo, int toPour){ //TODO EDIT / 2 IF
        while (!bottleTwo.isFull() && toPour > -1){ //&& !this.isEmpty() &&
            //System.out.println(toPour +" DEPRESSION TIME for Bottle " + getName() + " /// " + bottleOne.CONTENT + "/" + bottleTwo.CONTENT);
            bottleOne.CONTENT--;
            bottleTwo.CONTENT++;
            toPour--;
            //TODO SOLVE

        }
    }
}