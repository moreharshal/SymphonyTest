package com.forcepoint.calculator;

/**
 * Calculator class providing addition functionality for various numeric types.
 * <p>
 * This class is part of RAP-838: Agent Symphony Testing - Part 3
 * Provides methods to add two numbers of different types (int, double, long).
 * </p>
 *
 * @author Symphony Agent
 * @version 1.0.0
 * @since 2026-06-02
 */
public class Calculator {

    /**
     * Adds two integer numbers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Adds two double numbers.
     * <p>
     * Note: Due to floating-point precision limitations, results may have
     * minor rounding errors. For financial calculations, consider using BigDecimal.
     * </p>
     *
     * @param a the first double
     * @param b the second double
     * @return the sum of a and b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Adds two long numbers.
     * <p>
     * Useful for handling large numbers beyond the range of int.
     * Note: Overflow behavior follows Java's standard long overflow semantics.
     * </p>
     *
     * @param a the first long
     * @param b the second long
     * @return the sum of a and b
     */
    public long add(long a, long b) {
        return a + b;
    }
}
