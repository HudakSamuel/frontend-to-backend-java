package sk.fei.stuba.zadanie3.web.domain_models;

import sk.fei.stuba.zadanie3.domain.Address;
import sk.fei.stuba.zadanie3.domain.contracts.non_life.HouseAndFlatInsurance;
import sk.fei.stuba.zadanie3.domain.user.User;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class HouseAndFlatInsuranceModel {
    private int id;
    @NotNull
    @FutureOrPresent
    private LocalDateTime dateOfCreation;
    private User assurer;
    @NotEmpty
    private String dateOfBegginingOfInsurance;
    @NotEmpty
    private String dateOfEndOfInsurance;
    @Positive
    private double insuranceAmount;
    @Positive
    private double monthlyPayment;
    @Min(1)
    @Max(3)
    private int propertyType;
    @Positive
    private double propertyValue;
    private boolean garageInsurance;
    private Address propertyAddress;

    public HouseAndFlatInsuranceModel(){}

    public HouseAndFlatInsuranceModel(HouseAndFlatInsurance houseAndFlatInsurance){
        this.id = houseAndFlatInsurance.getId();
        this.dateOfCreation = houseAndFlatInsurance.getDateOfCreation();
        this.assurer = houseAndFlatInsurance.getAssurer();
        this.dateOfBegginingOfInsurance = houseAndFlatInsurance.getDateOfBegginingOfInsurance();
        this.dateOfEndOfInsurance = houseAndFlatInsurance.getDateOfEndOfInsurance();
        this.insuranceAmount = houseAndFlatInsurance.getInsuranceAmount();
        this.monthlyPayment = houseAndFlatInsurance.getMonthlyPayment();
        this.propertyType = houseAndFlatInsurance.getPropertyType();
        this.propertyValue = houseAndFlatInsurance.getPropertyValue();
        this.garageInsurance = houseAndFlatInsurance.isGarageInsurance();
        this.propertyAddress = houseAndFlatInsurance.getPropertyAddress();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public User getAssurer() {
        return assurer;
    }

    public void setAssurer(User assurer) {
        this.assurer = assurer;
    }

    public String getDateOfBegginingOfInsurance() {
        return dateOfBegginingOfInsurance;
    }

    public void setDateOfBegginingOfInsurance(String dateOfBegginingOfInsurance) {
        this.dateOfBegginingOfInsurance = dateOfBegginingOfInsurance;
    }

    public String getDateOfEndOfInsurance() {
        return dateOfEndOfInsurance;
    }

    public void setDateOfEndOfInsurance(String dateOfEndOfInsurance) {
        this.dateOfEndOfInsurance = dateOfEndOfInsurance;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(int propertyType) {
        this.propertyType = propertyType;
    }

    public double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(double propertyValue) {
        this.propertyValue = propertyValue;
    }

    public boolean isGarageInsurance() {
        return garageInsurance;
    }

    public void setGarageInsurance(boolean garageInsurance) {
        this.garageInsurance = garageInsurance;
    }

    public Address getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(Address propertyAddress) {
        this.propertyAddress = propertyAddress;
    }
}
