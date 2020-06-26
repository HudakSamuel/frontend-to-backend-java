package sk.fei.stuba.zadanie3.domain.contracts.life;

import sk.fei.stuba.zadanie3.domain.user.User;

import java.time.LocalDateTime;

public class InjuryInsurance extends LifeInsurance {

    private double permanentInjury;                //suma pri trvalom uraze
    private double death;                          //suma pri umrti
    private double dailyHospitalizationAmount;
    private int validArea;                          //uzemie platnosti: 1 - Slovensko, 2 - Svet, 3 - Svet + Slovensko

    public InjuryInsurance(){}

    public InjuryInsurance(int prevID, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance,
                           String dateOfEndOfInsurance, double insuranceAmount, double monthlyPayment, User assured, double permanentInjury,
                           double death, double dailyHospitalizationAmount, int validArea){

        this.id = prevID + 1;
        setDateOfCreation(dateOfCreation);
        setAssurer(assurer);
        setDateOfBegginingOfInsurance(dateOfBegginingOfInsurance);
        setDateOfEndOfInsurance(dateOfEndOfInsurance);
        setInsuranceAmount(insuranceAmount);
        setMonthlyPayment(monthlyPayment);
        setAssured(assured);
        setPermanentInjury(permanentInjury);
        setDeath(death);
        setDailyHospitalizationAmount(dailyHospitalizationAmount);
        setValidArea(validArea);

    }

    public void setPermanentInjury(double permanentInjury) {
        if (permanentInjury <= 0){
            throw new IllegalArgumentException();
        }
        this.permanentInjury = permanentInjury;
    }

    public void setDeath(double death) {
       if (death <= 0){
           throw new IllegalArgumentException();
        }
        this.death = death;
    }

    public void setDailyHospitalizationAmount(double dailyHospitalizationAmount) {
        if (dailyHospitalizationAmount <= 0){
            throw new IllegalArgumentException();
        }
        this.dailyHospitalizationAmount = dailyHospitalizationAmount;
    }

    public void setValidArea(int validArea) {
        if (validArea == 1 || validArea == 2 || validArea == 3){
            this.validArea = validArea;
        }
        else{ throw new IllegalArgumentException(); }
    }

    public double getPermanentInjury() {
        return permanentInjury;
    }

    public double getDeath() {
        return death;
    }

    public double getDailyHospitalizationAmount() {
        return dailyHospitalizationAmount;
    }

    public int getValidArea() {
        return validArea;
    }



    @Override
    public String toString() {
        return "InjuryInsurance{" +
                "permanentInjury=" + permanentInjury +
                ", death=" + death +
                ", dailyHospitalizationAmount=" + dailyHospitalizationAmount +
                ", validArea=" + validArea +
                ", assured=" + assured +
                ", id=" + id +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                ", assurer=" + assurer +
                ", dateOfBegginingOfInsurance='" + dateOfBegginingOfInsurance + '\'' +
                ", dateOfEndOfInsurance='" + dateOfEndOfInsurance + '\'' +
                ", insuranceAmount=" + insuranceAmount +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
