package org.example;
import java.util.Scanner;

class CabService {
    public static void main(String[] args) {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        //Taking distance and time as input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double distance = scanner.nextDouble();// in kilometers
        System.out.print("Enter time taken in minutes: ");
        int time = scanner.nextInt(); // in minutes

        //Calculating total fare
        double fare = invoiceGenerator.calculateFare(distance, time);

        // Printing total fare of user for ride
        System.out.println("Total Fare: Rs. " + fare);
    }
}