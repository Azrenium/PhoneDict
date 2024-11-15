package com.github.azrenium;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    private static final Dictionary<String, String> dictionary = new Hashtable<>();
    private static final Scanner scan = new Scanner(System.in);

    private static final String options = """
            
            --------------------
            What would you like to do?
            1. Read the phone book.
            2. Add a new entry
            3. Update an entry
            4. Remove an entry
            5. Exit
            --------------------""";

    public static void main(String[] args) {
        while(true){
            System.out.println(options);
            String in = scan.nextLine();

            switch (in){
                case "1":
                    displayPhoneBook();
                    continue;
                case "2":
                    addNewEntry();
                    continue;
                case "3":
                    updateAnEntry();
                    continue;
                case "4":
                    removeAnEntry();
                    continue;
            }

            if(in.equalsIgnoreCase("5")){
                break;
            } else {
                System.out.println("Wrong Input!");
            }
        }
    }

    private static void displayPhoneBook() {
        System.out.println("Phone Book:");
        ((Hashtable<String, String>) dictionary).forEach((key, value) -> System.out.println(key + " : " + value));
    }

    private static void addNewEntry(){
        System.out.print("Name to add: ");
        String name = scan.nextLine();
        System.out.print("Number: ");
        String number = scan.nextLine();

        dictionary.put(name, number);
        System.out.println("Added an entry!");
    }

    private static void updateAnEntry(){
        System.out.print("Name to update: ");
        String name = scan.nextLine();

        if(dictionary.get(name) != null){
            System.out.print("New number: ");
            String number = scan.nextLine();
            dictionary.put(name, number);
            System.out.println("Updated!");
        } else{
            System.out.println("This name doesn't exist in the phone book!");
        }
    }

    private static void removeAnEntry() {
        System.out.print("Name to remove: ");
        String name = scan.nextLine();

        String a = dictionary.remove(name);
        System.out.println(a != null ? "Removed!" : "No such value!");
    }
}