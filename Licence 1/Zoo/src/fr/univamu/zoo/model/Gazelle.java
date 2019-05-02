package fr.univamu.zoo.model;

public class Gazelle {

  private final String name;
  private int age;
  private double weight;
  private int hornsLength;

  public Gazelle(String name) {
    this.name = name;
    this.age = 1;
    this.weight = 12;
    this.hornsLength = 9;
  }

  public Gazelle(String name, int age, double weight, int hornsLength) {
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.hornsLength = hornsLength;
  }

  public void eat() {
    weight = weight + 0.075;
  }

  public void sleep() {
    weight = weight - 0.050;
  }

  public void run() {
    weight = weight - 0.010;
  }

  public void jump() {
    weight = weight - 0.010;
  }

  public String toString() {
    return "I'm a Gazelle, my name is " + name + ", "
        + "I'm " + age + ", "
        + "I weigh " + weight + "kg "
        + "and my horns are "+ hornsLength + "cm long.";
  }

}
