package ru.phone;


import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class Loader extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("loader");
        }
    }


    public static synchronized ArrayList<Contact> simpleFIleReader() throws FileNotFoundException, IOException {
        BufferedReader readFile = new BufferedReader(new FileReader(PhoneBook.fileName));
        String str;
        ArrayList<String> contactsString = new ArrayList<String>();
        while((str=readFile.readLine())!=null){
            contactsString.add(str.trim());
        }
        readFile.close();
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        for (int i = 0; i < contactsString.size(); i++) {
            String[] partsOfContact = contactsString.get(i).split(" ");
            contacts.add(new Contact(partsOfContact[0], partsOfContact[1], Integer.parseInt(partsOfContact[2])));
        }
        return contacts;
    }

    public static synchronized ArrayList<Contact> jsonFileReader() throws FileNotFoundException, IOException{
        BufferedReader readFile = new BufferedReader(new FileReader(PhoneBook.jsonFileName));
        Gson gson = new Gson();

        String str;
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        while((str=readFile.readLine())!=null){
            contacts.add(gson.fromJson(str, Contact.class));
        }
        readFile.close();
        return contacts;
    }

    public static synchronized ArrayList<Contact> serialFIleReader() throws IOException{
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(PhoneBook.serialFileName));
            try {
                contacts.addAll((ArrayList<Contact>) inputStream.readObject());
            }catch (ClassNotFoundException e){
                System.out.println("Класс не найден");
            } catch (StreamCorruptedException e){
                System.out.println("хана потоку");
            }
        inputStream.close();
        return contacts;
    }
}
