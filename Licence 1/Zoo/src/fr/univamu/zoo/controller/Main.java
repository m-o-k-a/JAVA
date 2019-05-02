package fr.univamu.zoo.controller;

import fr.univamu.zoo.view.Zoo;

public class Main {

  public static void main(String[] args) {
    Zoo z = new Zoo();
    z.display();
    System.out.println("At lunch!!!!!");
    z.feed();
    z.display();
  }

}
