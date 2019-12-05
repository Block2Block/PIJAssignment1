package com.bham.pij.assignments.passwordchecker;

import java.util.Scanner;

public class PasswordChecker {



    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker();

        System.out.println("Please type a password:");
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        System.out.println(pc.checkPassword(password));
    }

    public String checkPassword(String input) {
        if (input.length() > 12) {
            return "TOO LONG";
        } else if (input.length() < 8) {
            return "TOO SHORT";
        }

        boolean containsUpper = false;
        boolean containsLower = false;

        for (char c : input.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return "WRONG CHARACTERS";
            }
            if (Character.isLowerCase(c)) {
                containsLower = true;
            } else if (Character.isUpperCase(c)) {
                containsUpper = true;
            }
        }
        if (Character.isDigit(input.toCharArray()[0])) {
            return "LEADING DIGIT";
        }

        if (!containsLower || !containsUpper) {
            return "NOT MIXED CASE";
        }

        return "OK";

    }

}
