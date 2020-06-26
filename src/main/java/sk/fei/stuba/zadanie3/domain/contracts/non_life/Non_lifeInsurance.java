package sk.fei.stuba.zadanie3.domain.contracts.non_life;

import sk.fei.stuba.zadanie3.domain.contracts.Contract;
import sk.fei.stuba.zadanie3.domain.Address;

public abstract class Non_lifeInsurance extends Contract {

    protected int propertyType;       // typ nehnutelnosti; 1 - Byt, 2 - Dom murovany, 3 - Dom drevenny
    protected Address propertyAddress;
    protected double propertyValue;

    public void setPropertyType(int propertyType) {
        if (propertyType == 1 || propertyType == 2 || propertyType == 3){
            this.propertyType = propertyType;
        }
        else{ throw new IllegalArgumentException(); }
    }

    public void setPropertyAddress(Address propertyAddress) {
        if (propertyAddress == null){
            throw new IllegalArgumentException();
        }
        this.propertyAddress = propertyAddress;
    }

    public void setPropertyValue(double propertyValue) {
        if (propertyValue <= 0) {
            throw new IllegalArgumentException();
        }
        this.propertyValue = propertyValue;
    }

    public int getPropertyType() {
        return propertyType;
    }

    public Address getPropertyAddress() {
        return propertyAddress;
    }

    public double getPropertyValue() {
        return propertyValue;
    }
}
