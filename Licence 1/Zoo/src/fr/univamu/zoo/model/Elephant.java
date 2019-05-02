package fr.univamu.zoo.model;

public class Elephant {
    private final String name;
    private int age;
    private double weight;
    private double trunkLength;


    public Elephant(String name, int age, double weight, double trunkLength) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.trunkLength = trunkLength;
    }

    public void eat() {
        weight += 8;
    }

    public void sleep() {
        weight -= 1;
    }

    public void run() {
        weight -= 1.3;
    }

    public String shout() {
        return "UHH UHHH";
    }

    public String toString() {
        return "I'm an Elephant, my name is " + name + ", " + "I'm " + age + ", " + "I weigh " + weight + "kg " + "and my trunk is "+ trunkLength + "cm long.";
    }


}
