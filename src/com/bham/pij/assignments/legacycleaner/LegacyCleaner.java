package com.bham.pij.assignments.legacycleaner;

import java.util.Scanner;

public class LegacyCleaner {

    public static void main(String[] args) {
        LegacyCleaner lc = new LegacyCleaner();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your legacy data:");
        String value = scanner.nextLine();

        String[] cleaned = lc.clean(value);

        for (String s : cleaned) {
            System.out.print(s + ", ");
        }
    }


    public String[] clean(String input) {
        String[] cleanedList = new String[4];
        if (input == null) {
            return null;
        } else if (input.equals("")||!input.contains(",")||input.replace(",","").equals("")) {
            return null;
        }

        for (String s : input.split(",")) {
            if (s.trim().equals("")) {
                continue;
            }
            if (s.trim().equals("FAIL")||s.trim().equals("PASS")||s.trim().equals("MERIT")) {
                cleanedList[2] = s.trim();
                continue;
            }

            boolean containsDigit = false;
            boolean containsSpace = false;
            for (char c : s.trim().toCharArray()) {
                if (Character.isDigit(c)) {
                    containsDigit = true;
                }
                if (Character.isSpaceChar(c)) {
                    containsSpace = true;
                }
            }

            if (containsDigit && !containsSpace) {
                if (s.trim().length() == 6) {
                    cleanedList[3] = s.trim();
                } else if (s.trim().length() == 7) {
                    cleanedList[1] = s.trim();
                }
                continue;
            }

            if (!containsSpace) {
                continue;
            }

            cleanedList[0] = s.trim();
        }

        return cleanedList;
    }

}
