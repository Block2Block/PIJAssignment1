package com.bham.pij.assignments.gradechecker;

import java.util.Scanner;

public class GradeChecker {


    final int PASS_GRADE = 40;

    public static void main(String[] args) {
        GradeChecker gc = new GradeChecker();
        System.out.println("Please enter a grade:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int grade = Integer.parseInt(input);
        if (gc.isValid(grade)) {
            if (gc.isPass(grade)) {
                System.out.println("Pass.");
            } else {
                System.out.println("Fail.");
            }
        } else {
            System.out.println("Invalid input");
        }
    }

    public boolean isPass(int grade) {
        if (grade >= PASS_GRADE) {
            return true;
        }
        return false;
    }

    public boolean isValid(int grade) {
        return grade >= 0 && grade <= 100;
    }

}
