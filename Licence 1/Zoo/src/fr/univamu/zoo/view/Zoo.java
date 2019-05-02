package fr.univamu.zoo.view;

import fr.univamu.zoo.model.Elephant;
import fr.univamu.zoo.model.Gazelle;
import fr.univamu.zoo.model.Lion;
import fr.univamu.zoo.model.Monkey;

public class Zoo {
  private Lion theLion;
  private Gazelle theGazelle ;
  private Monkey theMonkey;
  private Elephant theElephant;

  public Zoo() {
    theLion = new Lion("Simba",4,167.5);
    theGazelle = new Gazelle("Lady Gaga");
    theMonkey = new Monkey("Cheeta");
    theElephant = new Elephant("kiki", 2, 54, 140);
  }

  public void display() {
    System.out.println(theLion.toString());
    System.out.println(theGazelle.toString());
    System.out.println(theMonkey.toString());
    System.out.println(theElephant.toString());

  }


  public void feed() {
    theLion.eat();
    theGazelle.eat();
    theMonkey.eat();
    theElephant.eat();

  }

}
