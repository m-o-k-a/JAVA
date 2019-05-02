package fr.univamu.zoo.model;

public class Lion {

  private final String name;
  private int age;
  private double weight;


  public Lion(String name, int age, double weight) {
    this.name = name;
    this.age = age;
    this.weight = weight;
  }

  public void eat() {
    weight = weight + 1.9;
  }

  public void sleep() {
    weight = weight - 0.8;
  }

  public void run() {
    weight = weight - 0.5;
  }

  public String shout() {
    return "Roaaaaar !";
  }

  public String toString() {
    return "I'm a Lion, my name is " + name + ", "
        + "I'm " + age + ", "
        + "I weigh " + weight + "kg.";
  }


}
