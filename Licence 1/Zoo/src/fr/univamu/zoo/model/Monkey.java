package fr.univamu.zoo.model;

public class Monkey {

  private final String name;
  private int age;
  private double weight;

  public Monkey(String name) {
    this.name = name;
    this.age = 1;
    this.weight = 1;
  }


  public Monkey(String name, int age, double weight) {
    this.name = name;
    this.age = age;
    this.weight = weight;
  }


  public void eat() {
    weight = weight + 0.3;
  }

  public void sleep() {
    weight = weight - 0.1;
  }

  public void run() {
    weight = weight - 0.120;
  }

  public void shout() {
    System.out.println("Wiwiwi!");
  }


  public String toString() {
    return "I'm a Monkey my name is " + name + ", "
        + "I'm " + age + ", "
        + "I weigh " + weight + "kg.";
  }

}
