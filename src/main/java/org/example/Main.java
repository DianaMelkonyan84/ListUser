package org.example;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> userList = new ArrayList<>();


    // Method to print user information including name, surname, profession, and age
    public static void printUserInfo(User user) {
        System.out.println("Id" + user.getId());
        System.out.println("Name: " + user.getFirstName());
        System.out.println("Surname: " + user.getLastName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Professions:");
        for (Profession profession : user.getProfessions()) {
            System.out.println("- " + profession.getTitle());
        }
        System.out.println();
    }

    // Method to find and print users by any input match in name, surname, street
    public static void findUsersByInput(String input) {
        boolean found = false;
        for (User user : userList) {
            if (user.getFirstName().toLowerCase().contains(input.toLowerCase()) ||
                    user.getLastName().toLowerCase().contains(input.toLowerCase()) ||
                    user.getAddress().getStreet().toLowerCase().contains(input.toLowerCase())
                   ) {
                printUserInfo(user);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching user found.");
        }
    }


    public static void main(String[] args) {
        // 15 users
        userList.add(new User(1, "John", "Bob", LocalDate.of(1980, 5, 15), new Address("Street1", "New York"), List.of(new Profession("Engineer"))));
        userList.add(new User(2, "Alice", "Smith", LocalDate.of(1990, 8, 25), new Address("Street2", "Los Angeles"), List.of(new Profession("Teacher"))));
        userList.add(new User(3, "Bob", "Johnson", LocalDate.of(1985, 3, 10), new Address("Street3", "Yerevan"), List.of(new Profession("Doctor"))));
        userList.add(new User(4, "Bob", "Johnson", LocalDate.of(1975, 3, 10), new Address("Street4", "Vanadzor"), List.of(new Profession("Doctor"))));
        userList.add(new User(5, "Max", "Rao", LocalDate.of(1965, 3, 10), new Address("Bob", "Gyumri"), List.of(new Profession("HR"))));
        userList.add(new User(6, "Bob", "Melkonyan", LocalDate.of(1975, 3, 10), new Address("Street5", "Vanadzor"), List.of(new Profession("Engineer"))));
        userList.add(new User(7, "Vika", "Simonyan", LocalDate.of(1975, 3, 10), new Address("Street6", "Berlin"), List.of(new Profession("Doctor"))));
        userList.add(new User(8, "Max", "Rao", LocalDate.of(1975, 3, 10), new Address("Street6", "Berlin"), List.of(new Profession("HR"))));
        userList.add(new User(9, "Bob", "Melkonyan", LocalDate.of(1975, 3, 10), new Address("Street7", "Abu-Dhabi"), List.of(new Profession("Engineer"))));
        userList.add(new User(10, "Vika", "Simonyan", LocalDate.of(1995, 3, 10), new Address("Street8", "Los"), List.of(new Profession("Doctor"))));
        userList.add(new User(11, "Bob", "Melkonyan", LocalDate.of(1985, 3, 10), new Address("Street9", "Chicago"), List.of(new Profession("Engineer"))));
        userList.add(new User(12, "Vika", "Simonyan", LocalDate.of(1975, 3, 10), new Address("Street10", "Chicago"), List.of(new Profession("Doctor"))));
        userList.add(new User(13, "Anri", "Rao", LocalDate.of(1999, 3, 10), new Address("Street11", "Mexico"), List.of(new Profession("HR"))));
        userList.add(new User(14, "Bob", "Melkonyan", LocalDate.of(1998, 3, 10), new Address("Street12", "Italy"), List.of(new Profession("Engineer"))));
        userList.add(new User(15, "Vika", "Simonyan", LocalDate.of(1975, 3, 10), new Address("Street13", "Vanadzor"), List.of(new Profession("Doctor"))));


        Scanner scanner = new Scanner(System.in);
        String input;

        // Main loop
        while (true) {
            System.out.print("Enter user name to find users on the same street, or press Enter to exit: ");
            input = scanner.nextLine();
            if (input.isEmpty() || input.equalsIgnoreCase("cancel")) {
                System.out.print("Cannot be empty" + "Or write cancel");
                if (input.equalsIgnoreCase("cancel")) {
                    System.out.println("Exiting...");
                    break;
                }
            }
            findUsersByInput(input);
        }
        scanner.close();
    }
}
