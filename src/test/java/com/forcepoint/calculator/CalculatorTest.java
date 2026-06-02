package com.forcepoint.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for Calculator class.
 * <p>
 * Tests cover various scenarios including:
 * - Positive and negative numbers
 * - Zero handling
 * - Decimal precision
 * - Large numbers
 * - Boundary conditions
 * - Integer overflow behavior
 * </p>
 *
 * @author Symphony Agent
 * @version 1.0.0
 * @since 2026-06-02
 */
@DisplayName("Calculator Test Suite - RAP-838")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // Integer Addition Tests

    @Test
    @DisplayName("Should add two positive integers")
    void testAddPositiveIntegers() {
        int result = calculator.add(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    @DisplayName("Should add two negative integers")
    void testAddNegativeIntegers() {
        int result = calculator.add(-5, -3);
        assertEquals(-8, result, "-5 + -3 should equal -8");
    }

    @Test
    @DisplayName("Should add positive and negative integers")
    void testAddMixedIntegers() {
        int result = calculator.add(10, -4);
        assertEquals(6, result, "10 + -4 should equal 6");
    }

    @Test
    @DisplayName("Should handle zero in integer addition")
    void testAddWithZeroInteger() {
        assertEquals(5, calculator.add(5, 0), "5 + 0 should equal 5");
        assertEquals(0, calculator.add(0, 0), "0 + 0 should equal 0");
        assertEquals(-5, calculator.add(0, -5), "0 + -5 should equal -5");
    }

    @Test
    @DisplayName("Should handle integer overflow correctly")
    void testIntegerOverflow() {
        // Integer overflow behavior - wraps around
        int result = calculator.add(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MIN_VALUE, result, 
            "Integer.MAX_VALUE + 1 should wrap to Integer.MIN_VALUE");
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, 2",
        "100, 200, 300",
        "-50, 50, 0",
        "999, 1, 1000"
    })
    @DisplayName("Parameterized test for integer addition")
    void testAddIntegersParameterized(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b), 
            a + " + " + b + " should equal " + expected);
    }

    // Double Addition Tests

    @Test
    @DisplayName("Should add two positive doubles")
    void testAddPositiveDoubles() {
        double result = calculator.add(5.5, 3.2);
        assertEquals(8.7, result, 0.0001, "5.5 + 3.2 should equal 8.7");
    }

    @Test
    @DisplayName("Should add two negative doubles")
    void testAddNegativeDoubles() {
        double result = calculator.add(-5.5, -3.2);
        assertEquals(-8.7, result, 0.0001, "-5.5 + -3.2 should equal -8.7");
    }

    @Test
    @DisplayName("Should add positive and negative doubles")
    void testAddMixedDoubles() {
        double result = calculator.add(10.5, -4.3);
        assertEquals(6.2, result, 0.0001, "10.5 + -4.3 should equal 6.2");
    }

    @Test
    @DisplayName("Should handle zero in double addition")
    void testAddWithZeroDouble() {
        assertEquals(5.5, calculator.add(5.5, 0.0), 0.0001, 
            "5.5 + 0.0 should equal 5.5");
        assertEquals(0.0, calculator.add(0.0, 0.0), 0.0001, 
            "0.0 + 0.0 should equal 0.0");
    }

    @Test
    @DisplayName("Should handle very small decimal numbers")
    void testAddVerySmallDoubles() {
        double result = calculator.add(0.0001, 0.0002);
        assertEquals(0.0003, result, 0.00001, 
            "0.0001 + 0.0002 should equal 0.0003");
    }

    @ParameterizedTest
    @CsvSource({
        "1.5, 2.5, 4.0",
        "10.25, 5.75, 16.0",
        "-3.5, 3.5, 0.0",
        "100.123, 200.456, 300.579"
    })
    @DisplayName("Parameterized test for double addition")
    void testAddDoublesParameterized(double a, double b, double expected) {
        assertEquals(expected, calculator.add(a, b), 0.0001,
            a + " + " + b + " should equal " + expected);
    }

    // Long Addition Tests

    @Test
    @DisplayName("Should add two positive longs")
    void testAddPositiveLongs() {
        long result = calculator.add(1000000000L, 2000000000L);
        assertEquals(3000000000L, result, 
            "1000000000 + 2000000000 should equal 3000000000");
    }

    @Test
    @DisplayName("Should add two negative longs")
    void testAddNegativeLongs() {
        long result = calculator.add(-1000000000L, -2000000000L);
        assertEquals(-3000000000L, result, 
            "-1000000000 + -2000000000 should equal -3000000000");
    }

    @Test
    @DisplayName("Should handle very large numbers with long")
    void testAddVeryLargeLongs() {
        long result = calculator.add(9223372036854775806L, 1L);
        assertEquals(9223372036854775807L, result, 
            "Should handle numbers near Long.MAX_VALUE");
    }

    @Test
    @DisplayName("Should handle zero in long addition")
    void testAddWithZeroLong() {
        assertEquals(1000000000L, calculator.add(1000000000L, 0L), 
            "1000000000 + 0 should equal 1000000000");
        assertEquals(0L, calculator.add(0L, 0L), 
            "0 + 0 should equal 0");
    }

    @Test
    @DisplayName("Should handle long overflow correctly")
    void testLongOverflow() {
        // Long overflow behavior - wraps around
        long result = calculator.add(Long.MAX_VALUE, 1L);
        assertEquals(Long.MIN_VALUE, result, 
            "Long.MAX_VALUE + 1 should wrap to Long.MIN_VALUE");
    }

    @ParameterizedTest
    @CsvSource({
        "1000000, 2000000, 3000000",
        "5000000000, 3000000000, 8000000000",
        "-1000000, 1000000, 0"
    })
    @DisplayName("Parameterized test for long addition")
    void testAddLongsParameterized(long a, long b, long expected) {
        assertEquals(expected, calculator.add(a, b),
            a + " + " + b + " should equal " + expected);
    }
}
