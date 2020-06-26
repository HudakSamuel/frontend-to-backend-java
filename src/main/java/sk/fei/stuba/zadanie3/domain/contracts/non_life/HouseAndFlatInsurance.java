package sk.fei.stuba.zadanie3.domain.contracts.non_life;

import sk.fei.stuba.zadanie3.domain.Address;
import sk.fei.stuba.zadanie3.domain.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HouseAndFlatInsurance extends Non_lifeInsurance {

    private boolean garageInsurance;        // 1 - ano 0 - nie

    public HouseAndFlatInsurance(int prevID, boolean garageInsurance, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance,
                                 String dateOfEndOfInsurance, double insuranceAmount, double monthlyPayment, int propertyType,
                                 Address propertyAddress, double propertyValue) {

        this.id = prevID + 1;
        setGarageInsurance(garageInsurance);
        setDateOfCreation(dateOfCreation);
        setAssurer(assurer);
        setDateOfBegginingOfInsurance(dateOfBegginingOfInsurance);
        setDateOfEndOfInsurance(dateOfEndOfInsurance);
        setInsuranceAmount(insuranceAmount);
        setMonthlyPayment(monthlyPayment);
        setPropertyType(propertyType);
        setPropertyAddress(propertyAddress);
        setPropertyValue(propertyValue);
    }

    public void setGarageInsurance(boolean garageInsurance) {
        this.garageInsurance = garageInsurance;
    }

    public boolean isGarageInsurance() {
        return garageInsurance;
    }

    @Override
    public String toString() {
        return "HouseAndFlatInsurance{" +
                "garageInsurance=" + garageInsurance +
                ", propertyType=" + propertyType +
                ", propertyAddress=" + propertyAddress +
                ", propertyValue=" + propertyValue +
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
