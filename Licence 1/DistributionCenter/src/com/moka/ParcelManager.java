package com.moka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParcelManager {

    private Map<Integer, Adress> distributionCenters;

    public ParcelManager(Map<Integer, Adress> distributionCenters){
        this.distributionCenters = distributionCenters;
    }

    public List<Parcel> attribute(List<Parcel> listParcel, int postalCode){
        List<Parcel> sortedByPostalCodeParcels = new ArrayList<>();
        for(Parcel parcel : listParcel){
            if (parcel.getAdress().getPostalCode() == postalCode){
                sortedByPostalCodeParcels.add(parcel);
            }
        } return sortedByPostalCodeParcels;
    }

    public Map<Adress, List<Parcel>> attributeDistributionCenter(List<Parcel> listParcel){
        Map<Adress, List<Parcel>> parcelAttribution = new HashMap<>();
        for(int i=0; i< distributionCenters.size(); i++){
            List<Parcel> attribution = attribute(listParcel, distributionCenters.get(i).getPostalCode());
            parcelAttribution.put(distributionCenters.get(i), attribution);
        } return parcelAttribution;
    }


    public List<Container> sendToContainers(List<Parcel> parcels){
        List<Container> containerList = new ArrayList<>();
        Container container = new Container();
        double parcelsWeight = 0;
        for (Parcel parcel : parcels){
            parcelsWeight += parcel.getWeight();
            if(parcelsWeight < container.getMAX_CAPACITY()){
                container.addParcel(parcel);
            }
            else {
                containerList.add(container);
                container = new Container();
            }
        } return containerList;
    }

}
