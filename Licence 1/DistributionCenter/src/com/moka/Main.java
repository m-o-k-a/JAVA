package com.moka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, Adress> distributionCenters = new HashMap<>();
    public static void main(String[] args) {
        List<Parcel> parcels = new ArrayList<>();

        Adress DC_MARSEILLE = new Adress("Distribution Center of Marseille", 13013, "Marseille", "La Poste Centre");
        Adress DC_LUMINY = new Adress("Distribution Center of Marseille - Luminy", 13009, "Marseille", "La Poste Luminy");
        Adress DC_DANANG = new Adress("Distribution Center of Da Nang", 550000, "Da Nang","Da Nang Post Office");
        Adress DC_HANOI = new Adress("Distribution Center of Hanoi", 100000, "Hanoi", "Hanoi Post Office");
        distributionCenters.put(0, DC_MARSEILLE);
        distributionCenters.put(1, DC_LUMINY);
        distributionCenters.put(2, DC_DANANG);
        distributionCenters.put(3, DC_HANOI);

        //delivery
        Adress addressParcelEddy = new Adress("Eddy", 13013, "Marseille", "In my home");
        Adress addressParcelOanh = new Adress("Oanh", 550000, "Da Nang", "In her house");
        Adress addressParcelHanoi = new Adress("Hanoi Post", 100000, "Hanoi", "With the other wish package");
        Adress addressParcelLuminy = new Adress("Luminy", 13009, "Marseille", "In the calanques");
        Parcel parcel1 = new Parcel(950, 340, addressParcelEddy);
        Parcel parcel2 = new Parcel(750, 400, addressParcelOanh);
        Parcel parcel3 = new Parcel(500, 400, addressParcelHanoi);
        Parcel parcel4 = new Parcel(1900, 5000, addressParcelLuminy);
        Parcel parcel5 = new Parcel(1000, 2000, addressParcelLuminy);
        parcels.add(parcel1);
        parcels.add(parcel2);
        parcels.add(parcel3);
        parcels.add(parcel4);
        parcels.add(parcel5);

        ParcelManager manager = new ParcelManager(distributionCenters);
        System.out.println("Number of Container used: "+manager.sendToContainers(parcels).size());
        System.out.println(manager.attributeDistributionCenter(parcels));
    }
}
