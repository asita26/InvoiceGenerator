package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class CabService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        // Assume you have a user ID for whom you want to calculate the invoice
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine().trim();

        // Fetch rides for the given user ID from the database
        List<Ride> rides = getRidesByUserId(userId);

        // Calculate and print the invoice details for the given user
        Invoice invoice = invoiceGenerator.calculateInvoice(rides);

        System.out.println("Invoice Details:");
        System.out.println("Total Number of Rides: " + invoice.getTotalRides());
        System.out.println("Total Fare for all rides: Rs. " + invoice.getTotalFare());
        System.out.println("Average Fare per Ride: Rs. " + invoice.getAverageFare());
    }

    private static List<Ride> getRidesByUserId(String userId) {
        List<Ride> rides = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT distance, duration FROM rides r " +
                             "JOIN user_rides ur ON r.ride_id = ur.ride_id " +
                             "WHERE ur.user_id = ?")) {

            preparedStatement.setString(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    double distance = resultSet.getDouble("distance");
                    int duration = resultSet.getInt("duration");
                    Ride ride = new Ride(distance, duration);
                    rides.add(ride);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rides;
    }
}



