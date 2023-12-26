package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class CabService {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

            List<Ride> rides = new ArrayList<>();

            // Take input for each ride from the user
            while (true) {
                System.out.print("Enter distance for the ride (in kilometers, or type 'exit' to finish): ");
                String distanceInput = scanner.nextLine().trim();

                if (distanceInput.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("Enter time for the ride (in minutes): ");
                String timeInput = scanner.nextLine().trim();

                try {
                    double distance = Double.parseDouble(distanceInput);
                    int time = Integer.parseInt(timeInput);
                    Ride ride = new Ride(distance, time);
                    rides.add(ride);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter valid numbers.");
                }
            }

            // Calculate and print the invoice details for all rides
            Invoice invoice = invoiceGenerator.calculateInvoice(rides);

            System.out.println("Invoice Details:");
            System.out.println("Total Number of Rides: " + invoice.getTotalRides());
            System.out.println("Total Fare for all rides: Rs. " + invoice.getTotalFare());
            System.out.println("Average Fare per Ride: Rs. " + invoice.getAverageFare());
        }
    }


