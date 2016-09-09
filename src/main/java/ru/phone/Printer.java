package ru.phone;

import java.io.IOException;

public class Printer {
    public static void printSimple() throws IOException {
        for (int i = 0; i < Loader.simpleFIleReader().size(); i++) {
            System.out.println("Имя: "+Loader.simpleFIleReader().get(i).getName()+" "+"Фамилия: "+Loader.simpleFIleReader().get(i).getSurName()+
                    " "+"Телефон: "+ Loader.simpleFIleReader().get(i).getPhone());
        }
        System.out.println();
    }

    public static void printJson() throws IOException{
        for (int i = 0; i < Loader.jsonFileReader().size(); i++) {
            System.out.println("Имя: "+Loader.jsonFileReader().get(i).getName()+" "+"Фамилия: "+Loader.jsonFileReader().get(i).getSurName()+
                    " "+"Телефон: "+ Loader.jsonFileReader().get(i).getPhone());
        }
        System.out.println();
    }

    public static void printSerial() throws IOException{
        for (int i = 0; i < Loader.serialFIleReader().size(); i++) {
            System.out.println("Имя: "+Loader.serialFIleReader().get(i).getName()+" "+"Фамилия: "+Loader.serialFIleReader().get(i).getSurName()+
                    " "+"Телефон: "+ Loader.serialFIleReader().get(i).getPhone());
        }
        System.out.println();
    }
}
