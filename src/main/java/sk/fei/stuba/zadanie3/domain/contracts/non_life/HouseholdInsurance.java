package sk.fei.stuba.zadanie3.domain.contracts.non_life;

import sk.fei.stuba.zadanie3.domain.Address;
import sk.fei.stuba.zadanie3.domain.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HouseholdInsurance extends Non_lifeInsurance {

    private double furnitureValue;

    public HouseholdInsurance(int prevID, double furnitureValue, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance,
                              String dateOfEndOfInsurance, double insuranceAmount, double monthlyPayment, int propertyType,
                              Address propertyAddress, double propertyValue){
        this.id = prevID + 1;
        setFurnitureValue(furnitureValue);
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

    public void setFurnitureValue(double furnitureValue) {
        if(furnitureValue <= 0){
            throw new IllegalArgumentException();
        }
        this.furnitureValue = furnitureValue;
    }

    public double getFurnitureValue() {
        return furnitureValue;
    }

    @Override
    public String toString() {
        return "HouseholdInsurance{" +
                "furnitureValue=" + furnitureValue +
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
