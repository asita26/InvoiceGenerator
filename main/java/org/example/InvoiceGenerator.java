package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceGenerator {
            public Invoice calculateInvoiceByUserId(String userId) {
                List<Ride> rides = getRidesByUserId(userId);
                return calculateInvoice(rides);
            }

            private List<Ride> getRidesByUserId(String userId) {
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
        private static final double COST_PER_KM = 10.0;
        private static final double COST_PER_MINUTE = 1.0;
        private static final double MINIMUM_FARE = 5.0;

        public Invoice calculateInvoice(List<Ride> rides) {
            double totalFare = 0;
            int totalRides = rides.size();

            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime());
            }

            double averageFare = totalRides > 0 ? totalFare / totalRides : 0;

            return new Invoice(totalRides, totalFare, averageFare);
        }

        private double calculateFare(double distance, int time) {
            double fare = distance * COST_PER_KM + time * COST_PER_MINUTE;
            return Math.max(fare, MINIMUM_FARE);
        }
    }
