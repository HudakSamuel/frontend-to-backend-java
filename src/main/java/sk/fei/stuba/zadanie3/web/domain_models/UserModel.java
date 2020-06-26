package sk.fei.stuba.zadanie3.web.domain_models;

import sk.fei.stuba.zadanie3.domain.Address;
import sk.fei.stuba.zadanie3.domain.contracts.Contract;
import sk.fei.stuba.zadanie3.domain.user.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class UserModel {

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

    public UserModel(){ }

    public UserModel(User user) {
        this.userID = user.getId();
        this.surName = user.getSurName();
        this.lastName = user.getLastName();
        this.pid = user.getPid();
        this.e_mail = user.getE_mail();
        this.permanentAddress = user.getPermanentAddress();
        this.postalAddress = user.getPostalAddress();
        this.contractList = user.getContractList();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }


}
