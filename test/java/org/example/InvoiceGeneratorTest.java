package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author meshwar
 * @date 26/12/23
 * @copyright Copyright (c) 2023 Your Company
 */
class InvoiceGeneratorTest {

    @Test
    void testCalculateFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

      // Test case 1: Single ride
        List<Ride> rides1 = new ArrayList<>();
        rides1.add(new Ride(2.5, 5));
        assertEquals(30.0, invoiceGenerator.calculateTotalFare(rides1));

     // Test case 2: Multiple rides
        List<Ride> rides2 = new ArrayList<>();
        rides2.add(new Ride(2.5, 5));
        rides2.add(new Ride(10.0, 60));
        rides2.add(new Ride(0.1, 1));
        assertEquals(195.0, invoiceGenerator.calculateTotalFare(rides2));

        // Test case 3: No rides
        List<Ride> rides3 = new ArrayList<>();
        assertEquals(0.0, invoiceGenerator.calculateTotalFare(rides3));
    }
}