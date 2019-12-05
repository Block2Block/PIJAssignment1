package com.bham.pij.assignments.shortidcreator;

import java.util.Scanner;

public class ShortIDCreator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShortIDCreator sic = new ShortIDCreator();

        System.out.println("Please enter a name:");
        String name = scanner.nextLine();

        System.out.println("ID: " + sic.createID(name));
    }

    public String createID(String input) {
        if (input == null) {
            return null;
        } else if (input == "" || input.split(" ").length > 3 || input.split(" ").length < 2) {
            return null;
        }
        input = input.toLowerCase();
        String[] names = input.split(" ");

        return (names[0].toCharArray()[0] + "" + ((names.length == 2)?"x" + names[1].toCharArray()[0]:names[1].toCharArray()[0] + "" + names[2].toCharArray()[0]));
    }

}
