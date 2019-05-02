package com.moka;

import java.util.Map;

public class Parcel {
    private double width;
    private double height;
    private double depth;
    private double weight;
    private Adress adress;
    private double volume;

    public Adress getAdress() { return adress; }
    public double getWeight() { return weight; }
    public double getVolume() { return volume; }

    public Parcel(double width, double height, double depth, Adress adress) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.adress = adress;
        this.volume = width*weight*depth;
    }

    public Parcel(double weight, double volume, Adress adress) {
        this.weight = weight;
        this.volume = volume;
        this.adress = adress;
    }

    public static double compareByWeight(Parcel p1, Parcel p2) {
        return (p1.getWeight()-p2.getWeight()); //(>0 p1>p2 // <0 p1<p2)
    }

    @Override
    public String toString() {
        return "Parcel for" + " " + adress.getRecipient();
    }
}
