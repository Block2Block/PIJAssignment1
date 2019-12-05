package com.bham.pij.assignments.fullidcreator;

import java.util.Scanner;

public class FullIDCreator {

    String[] shortIDs = new String[0];
    int[] increments = new int[0];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FullIDCreator fic = new FullIDCreator();

        while (true) {
            System.out.println("Please enter a name:");
            String name = scanner.nextLine();

            if (name.equals("exit")) {
                break;
            }

            System.out.println("ID: " + fic.createFullID(name));
        }


    }

    public String createFullID(String input) {
        String shortID = createID(input);

        if (shortID == null) {
            return null;
        }

        int number = 0;

        boolean idFound = false;
        int index = 0;
        for (String s : shortIDs) {
            if (s.equals(shortID)) {
                number = increments[index];
                increments[index]++;
                idFound = true;
                break;
            }
            index++;
        }


        String id = "" + number;
        while (id.split("").length < 4) {
            id = "0" + id;
        }

        if (!idFound) {
            String[] oldShortIDs = shortIDs.clone();
            int[] oldIncrements = increments.clone();

            int size = shortIDs.length;

            shortIDs = new String[size + 1];
            increments = new int[size + 1];

            int counter = 0;
            for (String s : oldShortIDs) {
                shortIDs[counter] = s;
                increments[counter] = oldIncrements[counter];
                counter++;
            }

            shortIDs[size] = shortID;
            increments[size] = Integer.parseInt(id) + 1;
        }

        return shortID + id;
    }

    public String createID(String input) {
        if (input == null) {
            return null;
        } else if (input == "" || input.split(" ").length > 3 || input.split(" ").length < 2) {
            return null;
        }
        input = input.toLowerCase();
        String[] names = input.split(" ");

        return (names[0].toCharArray()[0] + "" + ((names.length == 2) ? "x" + names[1].toCharArray()[0] : names[1].toCharArray()[0] + "" + names[2].toCharArray()[0]));
    }

}
