package com.company;


import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int principal = 0;
        double annualRate = 0;
        int period = 0;
        double monthlyRate = 0;
        int numberOfPayments = 0;

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
            break;
            System.out.println("Enter a value between 1000 and 100000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualRate = scanner.nextDouble();
            if (annualRate >= 1 && annualRate <= 30) {
                monthlyRate = (annualRate / 100) / 12;
                break;
            }
            System.out.println("Enter a value between 0 and 30");
        }


        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextInt();
            if ( period >= 1 && period <= 30) {
                numberOfPayments = period * 12;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }




        double monthlyMortgage = principal
                * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(monthlyMortgage);


        System.out.println("Mortgage: " + mortgageFormatted);

    }
}