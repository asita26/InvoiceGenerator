package org.example;

import org.junit.jupiter.api.Test;

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

        // Test case 1: edge case for generating minimum fare
        assertEquals(5.0, invoiceGenerator.calculateFare(0.009,1));

        // Test case 2: Short distance and low time
        assertEquals(30.0, invoiceGenerator.calculateFare(2.5, 5));

        // Test case 3: Long distance, moderate time
        assertEquals(160.0, invoiceGenerator.calculateFare(10.0, 60));

        // Test case 4: Minimum fare
        assertEquals(5.0, invoiceGenerator.calculateFare(0.1, 1));

        // Test case 5: Distance-only calculation
        assertEquals(20.0, invoiceGenerator.calculateFare(2.0, 0));

        // Test case 6: Time-only calculation
        assertEquals(25.0, invoiceGenerator.calculateFare(0.0, 25));
    }
}