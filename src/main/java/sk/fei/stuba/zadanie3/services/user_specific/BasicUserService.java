package sk.fei.stuba.zadanie3.services.user_specific;

import org.springframework.stereotype.Service;
import sk.fei.stuba.zadanie3.services.ListOperationsService;
import sk.fei.stuba.zadanie3.domain.Address;
import sk.fei.stuba.zadanie3.domain.user.User;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class BasicUserService implements ListOperationsService, UserSpecificService {

    private List<User> list;

    public BasicUserService(){
        this.list = new LinkedList<User>();
    }

    public void addUser(String surName, String lastName, String pid, String e_mail, Address permanentAddress, Address postalAddress){

        int prevID = findLastID();
        User newUser = new User(prevID,surName, lastName, pid, e_mail, permanentAddress, postalAddress);
        this.list.add(newUser);
    }

    public void modifyUser(int id, String surName, String lastName, String pid, String e_mail, Address permanentAddress, Address postalAddress){

        User user = getUser(id);
        if (user != null){
            user.setSurName(surName);
            user.setLastName(lastName);
            user.setPid(pid);
            user.setE_mail(e_mail);
            user.setPermanentAddress(permanentAddress);
            user.setPostalAddress(postalAddress);
        }
    }

    public void listAll(){

        if (this.list.size() > 0){
            for (int index = 0; index < this.list.size(); index++){
                System.out.println( this.list.get(index).getSurName() + this.list.get(index).getLastName() + " - " + this.list.get(index).getId() );
            }
            System.out.println("\n");
        }
    }

    public void listUserDetails(int id){

        User user = getUser(id);
        if (user != null){
            System.out.println(user + "\n");
        }
    }

    public User getUser(int id){

        for (int index = 0; index < this.list.size(); index++){
            if (this.list.get(index).getId() == id){
                return this.list.get(index);
            }
        }

        System.out.println("User not found");
        return null;
    }

    public int findLastID(){

        if (this.list.size() == 0){
            return 0;
        }
        Iterator<User> iterator = this.list.iterator();
        Iterator<User> tempIterator = this.list.iterator();

        while(iterator.hasNext()){
            tempIterator.next();
            if (!tempIterator.hasNext()){
                User user = iterator.next();
                return user.getId();
            }
            iterator.next();
        }

        return 0;

    }

    public List<User> getList() {
        return this.list;
    }
}
