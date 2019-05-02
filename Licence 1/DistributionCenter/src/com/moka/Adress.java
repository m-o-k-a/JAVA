package com.moka;

import java.util.Objects;

public class Adress {
    private String recipient;
    private int postalCode;
    private String city;
    private String street;

    public String getRecipient() { return recipient; }
    public int getPostalCode() { return postalCode; }
    public String getCity() { return city; }
    public String getStreet() { return street; }

    public Adress(String recipient, int postalCode, String city, String street) {
        this.recipient = recipient;
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient, postalCode, city, street);
    }

    public boolean equals(Adress adress) {
        return (this.getRecipient() == adress.getRecipient())
                &&(this.getPostalCode() == adress.getPostalCode())
                &&(this.getCity() == adress.getCity())
                &&(this.getStreet() == adress.getStreet());
    }

    @Override
    public String toString(){
        return recipient;
    }
}
