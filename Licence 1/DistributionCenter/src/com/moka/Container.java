package com.moka;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class Container implements Iterable<Parcel>{
    private double totalWeight = 0;
    private final int MAX_CAPACITY = 2000;
    private List<Parcel> parcels = new ArrayList<>();


    public boolean canAddParcel(Parcel parcel) {
        return parcel.getWeight() + this.totalWeight <= MAX_CAPACITY;
    }

    public double getTotalWeight() { return totalWeight; }

    public int getMAX_CAPACITY() { return MAX_CAPACITY; }

    public void addParcel(Parcel parcel) {
        if (canAddParcel(parcel)) {
            this.totalWeight += parcel.getWeight();
            parcels.add(parcel);
        }
    }

    @Override
    public Iterator<Parcel> iterator() {
        return null;
    }

    @Override
    public Spliterator<Parcel> spliterator() { return null; }
}
