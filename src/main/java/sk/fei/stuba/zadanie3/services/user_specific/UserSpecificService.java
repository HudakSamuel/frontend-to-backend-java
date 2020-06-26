package sk.fei.stuba.zadanie3.services.user_specific;

import org.springframework.stereotype.Service;
import sk.fei.stuba.zadanie3.domain.Address;
import sk.fei.stuba.zadanie3.domain.user.User;

@Service
public interface UserSpecificService {

    void addUser(String surName, String lastName, String pid, String e_mail, Address permanentAddress, Address postalAddress);
    void modifyUser(int id, String surName, String lastName, String pid, String e_mail, Address permanentAddress, Address postalAddress);
    void listUserDetails(int id);
    User getUser(int id);
}
