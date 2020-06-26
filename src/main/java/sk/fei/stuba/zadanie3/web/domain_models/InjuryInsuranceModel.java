package sk.fei.stuba.zadanie3.web.domain_models;

import sk.fei.stuba.zadanie3.domain.contracts.life.InjuryInsurance;
import sk.fei.stuba.zadanie3.domain.user.User;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class InjuryInsuranceModel {
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
    @PositiveOrZero
    private double permanentInjury;
    @PositiveOrZero
    private double death;
    @PositiveOrZero
    private double dailyHospitalizationAmount;
    private User assured;
    @Min(1)
    @Max(3)
    private int validArea;

    public InjuryInsuranceModel(){}

    public InjuryInsuranceModel(InjuryInsurance injuryInsurance){
        this.id = injuryInsurance.getId();
        this.dateOfCreation = injuryInsurance.getDateOfCreation();
        this.assurer = injuryInsurance.getAssurer();
        this.assured = injuryInsurance.getAssured();
        this.dateOfEndOfInsurance = injuryInsurance.getDateOfEndOfInsurance();
        this.insuranceAmount = injuryInsurance.getInsuranceAmount();
        this.monthlyPayment = injuryInsurance.getMonthlyPayment();
        this.permanentInjury = injuryInsurance.getMonthlyPayment();
        this.death = injuryInsurance.getDeath();
        this.dailyHospitalizationAmount = injuryInsurance.getDailyHospitalizationAmount();
        this.validArea = injuryInsurance.getValidArea();
        this.dateOfBegginingOfInsurance = injuryInsurance.getDateOfBegginingOfInsurance();
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

    public double getPermanentInjury() {
        return permanentInjury;
    }

    public void setPermanentInjury(double permanentInjury) {
        this.permanentInjury = permanentInjury;
    }

    public double getDeath() {
        return death;
    }

    public void setDeath(double death) {
        this.death = death;
    }

    public double getDailyHospitalizationAmount() {
        return dailyHospitalizationAmount;
    }

    public void setDailyHospitalizationAmount(double dailyHospitalizationAmount) {
        this.dailyHospitalizationAmount = dailyHospitalizationAmount;
    }

    public int getValidArea() {
        return validArea;
    }

    public void setValidArea(int validArea) {
        this.validArea = validArea;
    }

    public User getAssured() {
        return assured;
    }

    public void setAssured(User assured) {
        this.assured = assured;
    }
}
