package com.bham.pij.assignments.shortaddresscreator;

import java.util.Scanner;

public class ShortAddressCreator {

    public static void main(String[] args) {
        ShortAddressCreator sac = new ShortAddressCreator();
        System.out.println("Please enter an address:");
        Scanner scanner = new Scanner(System.in);

        String address = scanner.nextLine();
        System.out.println(sac.createShortAddress(address));
    }

    public String createShortAddress(String input) {
        if (input == null) {
            return null;
        }
        if (input.trim().equals("")) {
            return null;
        }

        String[] address = input.split(",");
        if (address.length < 2) {
            return null;
        }
        String[] trimmedAddress = new String[address.length];

        int counter = 0;
        for (String line : address) {
            line = line.trim();
            if (line.equals("")||line.equals(" ")) {
                return null;
            }
            trimmedAddress[counter] = line;
            counter++;
        }

        if (trimmedAddress[0].split(" ").length < 2) {
            return null;
        }

        String postcode = trimmedAddress[trimmedAddress.length - 1];

        if (postcode.length() != 6){
            return null;
        }

        char[] postcodeChars = postcode.toCharArray();

        for (int x = 0;x < 6;x++) {
            switch (x) {
                case 0:
                case 4:
                case 5:
                    if (!Character.isLetter(postcodeChars[x])||!Character.isUpperCase(postcodeChars[x])) {
                        return null;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (!Character.isDigit(postcodeChars[x])) {
                        return null;
                    }
                    break;
                default:
                    break;
            }
        }

        return trimmedAddress[0] + " " + trimmedAddress[trimmedAddress.length - 1];

    }

}
