package ru.phone;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class PhoneBook {
    public static void main(String[] args) throws IOException{
        print();
    }

    public static String fileName = "simple_file";
    public static String jsonFileName = "json_file";
    public static String serialFileName = "serial_file";
    public static final String[] words = new String[3];



    public static void print() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("1. Введите 1 для того чтобы внести новую запись в тел. книгу");
            System.out.println("2. Введите 2 для того чтобы посмотреть контакты");
            System.out.println("3. Введите 3 для того чтобы exit");
            System.out.println();
            System.out.println("4 чтобы проверить жив поток saver");
            System.out.println("5 чтобы проверить жив поток loader");
            String strReader = reader.readLine();
            if (strReader.equals("1")) {
                System.out.println("Введите фамилию имя и телефон через enter");
                ArrayList<String> list = new ArrayList<String>();
                for (int i = 0; i < 3; i++) {
                    words[i] = reader.readLine();
                }
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < words.length; i++) {
                    s.append(words[i] + " ");
                }
                list.add(s.toString());
                Thread threadSaver = new Thread(new Runnable() {
                    public void run() {
                        try {
                            Saver.writeSimpleFile(Contact.convertStringToContact(words));
                            Saver.writeToJsonFile(Contact.convertStringToContact(words));
                            Saver.writeSerializble(Contact.convertStringToContact(words));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
                Thread threadLoader = new Thread(new Runnable() {
                    public void run() {
                        try {
                            Loader.serialFIleReader();
                            Loader.jsonFileReader();
                            Loader.simpleFIleReader();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                threadSaver.start();
            } else if ("2".equals(strReader)) {
            if(Loader.simpleFIleReader().equals(Loader.jsonFileReader().equals(Loader.serialFIleReader()))){
                System.out.println("одинаковые файлы!!!");
            }    else{
                System.out.println("Нажми цифру, если один, то будет первый файл, если два, другой, 3 третий");
                String s = reader.readLine();
                        if("1".equals(s)){
                            Printer.printSimple();
                        }
                        else if("2".equals(s)){
                            Printer.printJson();
                        }
                        else if("3".equals(s)){
                            Printer.printSerial();
                        };
            }
            } else if (strReader.equals("3")) {
                break;
            }
        }
    }
}
