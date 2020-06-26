package sk.fei.stuba.zadanie3.domain.contracts.life;

import sk.fei.stuba.zadanie3.domain.user.User;

import java.time.LocalDateTime;

public class TravelInsurance extends LifeInsurance {

    private boolean inEU;           //1 for EU, 0 outside EU
    private int tripPurpouse;       //1 - work, 2 - holiday, 3 - family visit

    public TravelInsurance(int prevID, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance,
                           String dateOfEndOfInsurance, double insuranceAmount, double monthlyPayment, User assured, boolean inEU, int tripPurpouse) {

        this.id = prevID + 1;
        setDateOfCreation(dateOfCreation);
        setAssurer(assurer);
        setDateOfBegginingOfInsurance(dateOfBegginingOfInsurance);
        setDateOfEndOfInsurance(dateOfEndOfInsurance);
        setInsuranceAmount(insuranceAmount);
        setMonthlyPayment(monthlyPayment);
        setAssured(assured);
        setInEU(inEU);
        setTripPurpouse(tripPurpouse);
    }

    public void setInEU(boolean inEU) {
        this.inEU = inEU;
    }

    public void setTripPurpouse(int tripPurpouse) {
        if (tripPurpouse == 1 || tripPurpouse == 2 || tripPurpouse == 3){
            this.tripPurpouse = tripPurpouse;
        }
        else{ throw new IllegalArgumentException(); }

    }

    public boolean isInEU() {
        return inEU;
    }

    public int getTripPurpouse() {
        return tripPurpouse;
    }

    @Override
    public String toString() {
        return "TravelInsurance{" +
                "inEU=" + inEU +
                ", tripPurpouse=" + tripPurpouse +
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
