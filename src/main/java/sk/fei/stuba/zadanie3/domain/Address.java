package sk.fei.stuba.zadanie3.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Address {

    @NotNull
    private int zipCode;

    @NotNull
    @Size(min=1, max=20)
    private String town;

    @NotNull
    @Size(min=1, max=20)
    private String street;

    @NotNull
    @Size(min=1, max=20)
    private String houseNumber;

    public Address(){}

    public Address(int zipCode, String town, String street, String houseNumber) {

        this.zipCode = zipCode;
        this.town = town;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public void setZipCode(int zipCode) {

        this.zipCode = zipCode;
    }

    public void setTown(String town) {
        if (town == null){
            throw new IllegalArgumentException();
        }
        this.town = town;
    }

    public void setStreet(String street) {
        if (street == null){
            throw new IllegalArgumentException();
        }
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        if (houseNumber == null){
            throw new IllegalArgumentException();
        }
        this.houseNumber = houseNumber;

    }

    public int getZipCode() {
        return zipCode;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipCode=" + zipCode +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
