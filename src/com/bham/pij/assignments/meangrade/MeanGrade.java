package com.bham.pij.assignments.meangrade;

import java.util.Scanner;

public class MeanGrade {

    public static void main(String[] args) {
        int[] grades = new int[4];
        int counter = 0;

        Scanner scanner = new Scanner(System.in);
        MeanGrade mg = new MeanGrade();

        System.out.println("Please input your 4 grades (follow each grade with an enter):");
        while (counter < 4) {
            String value = scanner.nextLine();
            int grade = Integer.parseInt(value);
            grades[counter] = grade;
            counter++;
        }

        double mean = mg.computeMean(grades);
        if (mean == -1.0) {
            System.out.println("Invalid value entered.");
        } else {
            System.out.println("Mean: " + mean);
        }
    }

    public double computeMean(int[] grades) {
        double total = 0;
        int amount = grades.length;
        for (int grade : grades) {
            if (grade > 100 || grade < 0) {
                return -1.0;
            }
            total += grade;
        }

        return (total / amount);
    }

}
