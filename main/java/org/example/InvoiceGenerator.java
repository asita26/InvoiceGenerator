package org.example;

import java.util.List;

    public class InvoiceGenerator {
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
