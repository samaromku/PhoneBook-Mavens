package ru.phone;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class Saver extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("saver");
        }
    }

    public static synchronized void writeSimpleFile(ArrayList<Contact> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(PhoneBook.fileName, true));
        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i).getName() + " " + list.get(i).getSurName() + " " + list.get(i).getPhone() + "\n");
        }
        writer.close();
    }

    public static synchronized void writeSerializble(ArrayList<Contact> contacts) throws IOException{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(PhoneBook.serialFileName, true));
            outputStream.writeObject(contacts);
        outputStream.flush();
        outputStream.close();
    }

    public static synchronized void writeToJsonFile(ArrayList<Contact> list) throws IOException{
        Gson gson = new Gson();

        BufferedWriter writer = new BufferedWriter(new FileWriter(PhoneBook.jsonFileName, true));
        for (int i = 0; i < list.size(); i++) {
            String json = gson.toJson(list.get(i));
            writer.write(json+"\n");
        }
        writer.close();
    }
}
