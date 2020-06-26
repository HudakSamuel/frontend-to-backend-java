package sk.fei.stuba.zadanie3.web.domain_models;

import sk.fei.stuba.zadanie3.domain.Address;

import javax.validation.Valid;

public class NestAddress {
    @Valid
    private Address permanentAddress;
    @Valid
    private Address postalAddress;

    public NestAddress(){}
    public NestAddress(Address permanentAddress, Address postalAddress){
        this.permanentAddress = permanentAddress;
        this.postalAddress = postalAddress;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }
}
