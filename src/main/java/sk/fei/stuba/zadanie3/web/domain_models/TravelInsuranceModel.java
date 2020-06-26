package sk.fei.stuba.zadanie3.web.domain_models;

import sk.fei.stuba.zadanie3.domain.contracts.life.TravelInsurance;
import sk.fei.stuba.zadanie3.domain.user.User;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class TravelInsuranceModel {
    protected int id;
    @NotNull
    @FutureOrPresent
    protected LocalDateTime dateOfCreation;
    protected User assurer;
    @NotEmpty
    protected String dateOfBegginingOfInsurance;
    @NotEmpty
    protected String dateOfEndOfInsurance;
    @Positive
    protected double insuranceAmount;
    @Positive
    protected double monthlyPayment;
    private User assured;
    private boolean inEU;
    @Min(1)
    @Max(3)
    private int tripPurpouse;

    public TravelInsuranceModel(){}

    public TravelInsuranceModel(TravelInsurance travelInsurance){
        this.id = travelInsurance.getId();
        this.dateOfCreation = travelInsurance.getDateOfCreation();
        this.assurer = travelInsurance.getAssurer();
        this.assured = travelInsurance.getAssured();
        this.dateOfEndOfInsurance = travelInsurance.getDateOfEndOfInsurance();
        this.insuranceAmount = travelInsurance.getInsuranceAmount();
        this.monthlyPayment = travelInsurance.getMonthlyPayment();
        this.dateOfBegginingOfInsurance = travelInsurance.getDateOfBegginingOfInsurance();
        this.inEU = travelInsurance.isInEU();
        this.tripPurpouse = travelInsurance.getTripPurpouse();
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

    public User getAssured() {
        return assured;
    }

    public void setAssured(User assured) {
        this.assured = assured;
    }

    public boolean isInEU() {
        return inEU;
    }

    public void setInEU(boolean inEU) {
        this.inEU = inEU;
    }

    public int getTripPurpouse() {
        return tripPurpouse;
    }

    public void setTripPurpouse(int tripPurpouse) {
        this.tripPurpouse = tripPurpouse;
    }


}
