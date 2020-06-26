package sk.fei.stuba.zadanie3.domain.contracts;

import org.springframework.format.annotation.DateTimeFormat;
import sk.fei.stuba.zadanie3.domain.user.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Contract {

    protected int id;
    protected LocalDateTime dateOfCreation;
    protected User assurer;
    protected String dateOfBegginingOfInsurance;
    protected String dateOfEndOfInsurance;
    protected double insuranceAmount;
    protected double monthlyPayment;

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        //if(dateOfCreation == null){
           // throw new IllegalArgumentException();
        //}
        this.dateOfCreation = LocalDateTime.now();
    }

    public void setAssurer(User assurer) {
        if (assurer == null){
            throw new IllegalArgumentException();
        }
        this.assurer = assurer;
    }

    public void setDateOfBegginingOfInsurance(String dateOfBegginingOfInsurance) {
        if (dateOfBegginingOfInsurance == null){
            throw new IllegalArgumentException();
        }
        this.dateOfBegginingOfInsurance = dateOfBegginingOfInsurance;
    }

    public void setDateOfEndOfInsurance(String dateOfEndOfInsurance) {
        if(dateOfEndOfInsurance == null){
            throw new IllegalArgumentException();
        }
        this.dateOfEndOfInsurance = dateOfEndOfInsurance;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        if (insuranceAmount <= 0){
            throw new IllegalArgumentException();
        }
        this.insuranceAmount = insuranceAmount;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        if (monthlyPayment <= 0) {
            throw new IllegalArgumentException();
        }
        this.monthlyPayment = monthlyPayment;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public User getAssurer() {
        return assurer;
    }

    public String getDateOfBegginingOfInsurance() {
        return dateOfBegginingOfInsurance;
    }

    public String getDateOfEndOfInsurance() {
        return dateOfEndOfInsurance;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setId(int id) {
        this.id = id;
    }
}
