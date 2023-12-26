package org.example;

public class Invoice {
    private int totalRides;
    private double totalFare;
    private double averageFare;

    public Invoice(int totalRides, double totalFare, double averageFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }
}
