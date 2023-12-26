package org.example;
import java.util.ArrayList;
import java.util.List;

// Ride.java
public class Ride {
    private double distance;
    private int time;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}