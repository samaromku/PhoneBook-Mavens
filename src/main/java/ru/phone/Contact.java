package ru.phone;

import java.io.Serializable;
import java.util.ArrayList;

public class Contact implements Serializable{
    private String name;
    private String surName;
    private int phone;

    public Contact(String name, String surName, int phone){
        this.name = name;
        this.surName = surName;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public static ArrayList<Contact> convertStringToContact(String[] words){
        ArrayList<Contact> contactArrayList = new ArrayList<Contact>();
        contactArrayList.add(new Contact(words[0], words[1], Integer.parseInt(words[2])));
        return contactArrayList;
    }
}
