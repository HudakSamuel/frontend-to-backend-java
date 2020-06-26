package sk.fei.stuba.zadanie3.domain.user;

import sk.fei.stuba.zadanie3.domain.Address;
import sk.fei.stuba.zadanie3.domain.contracts.Contract;

import javax.validation.constraints.*;
import java.util.LinkedList;
import java.util.List;

public class User {

    private int userID;

    @NotNull
    @Size(min=1, max=20)
    private String surName;

    @NotNull
    @Size(min=1, max=20)
    private String lastName;

    @NotNull
    @NotEmpty
    private String pid;

    @NotEmpty
    @Email
    private String e_mail;

    @NotNull
    private Address permanentAddress;

    @NotNull
    private Address postalAddress;
    private List<Contract> contractList;

    public User(){ }

    public User(int prevID, String surName, String lastName, String pid, String e_mail, Address permanentAddress, Address postalAddress) {

        this.userID = prevID + 1;
        setSurName(surName);
        setLastName(lastName);
        setPid(pid);
        setE_mail(e_mail);
        setPermanentAddress(permanentAddress);
        setPostalAddress(postalAddress);
        this.contractList = new LinkedList<Contract>();
    }

    public int getId() {
        return userID;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        if (surName == null){
            throw new IllegalArgumentException();
        }
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null){
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;

    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setE_mail(String e_mail) {
        if (e_mail == null){
            throw new IllegalArgumentException();
        }
        this.e_mail = e_mail;
    }

    public void setPermanentAddress(Address permanentAddress) {
        if (permanentAddress == null){
            throw new IllegalArgumentException();
        }
        this.permanentAddress = permanentAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        if (postalAddress == null){
            throw new IllegalArgumentException();
        }
        this.postalAddress = postalAddress;
    }

    public String getE_mail() {
        return e_mail;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public String getPid() {
        return pid;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + userID +
                ", surName='" + surName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pid=" + pid +
                ", e_mail='" + e_mail + '\'' +
                ", permanentAddress=" + permanentAddress +
                ", postalAddress=" + postalAddress +
                '}';
    }
}
