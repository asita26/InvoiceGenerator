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
        Invoice invoice1 = invoiceGenerator.calculateInvoice(rides1);
        assertEquals(1, invoice1.getTotalRides());
        assertEquals(30.0, invoice1.getTotalFare());
        assertEquals(30.0, invoice1.getAverageFare());

        // Test case 2: Multiple rides
        List<Ride> rides2 = new ArrayList<>();
        rides2.add(new Ride(2.5, 5));
        rides2.add(new Ride(10.0, 60));
        rides2.add(new Ride(0.1, 1));
        Invoice invoice2 = invoiceGenerator.calculateInvoice(rides2);
        assertEquals(3, invoice2.getTotalRides());
        assertEquals(195.0, invoice2.getTotalFare());
        assertEquals(65.0, invoice2.getAverageFare(), 0.01);

        // Test case 3: No rides
        List<Ride> rides3 = new ArrayList<>();
        Invoice invoice3 = invoiceGenerator.calculateInvoice(rides3);
        assertEquals(0, invoice3.getTotalRides());
        assertEquals(0.0, invoice3.getTotalFare());
        assertEquals(0.0, invoice3.getAverageFare());
    }
}