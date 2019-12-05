package com.bham.pij.assignments.resultchecker;

import java.util.Scanner;

public class ResultChecker {

    public static void main(String[] args) {
        ResultChecker rc = new ResultChecker();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the project grade, followed by the 8 module grades:");

        String project = scanner.nextLine();
        int projectGrade = Integer.parseInt(project);

        int counter = 0;
        int[] grades = new int[8];
        while (counter < 8) {
            String value = scanner.nextLine();
            int grade = Integer.parseInt(value);
            grades[counter] = grade;
            counter++;
        }

        System.out.println(rc.getResult(grades, projectGrade));
    }

    public String getResult(int[] grades, int projectGrade) {
        if (projectGrade > 100 || projectGrade < 0) {
            return "ERROR";
        }
        if (projectGrade < 40) {
            return "FAIL";
        }

        double mean = computeMean(grades);
        if (mean == -1.0) {
            return "ERROR";
        } else if (mean == -2.0) {
            return "FAIL";
        } else if (mean < 50.0 || projectGrade < 50) {
            return "PASS";
        }

        return "MERIT";
    }

    public double computeMean(int[] grades) {
        double total = 0;
        int amount = grades.length;
        for (int grade : grades) {
            if (grade > 100 || grade < 0) {
                return -1.0;
            } else if (grade < 40) {
                return -2.0;
            }
            total += grade;
        }

        return (total / amount);
    }
}
