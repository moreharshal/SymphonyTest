package com.forcepoint.calculator;

import java.util.Scanner;

/**
 * Interactive CLI application for testing the Calculator.
 * <p>
 * This application provides a simple command-line interface for manual testing
 * of the addition functionality implemented in the Calculator class.
 * Part of RAP-838: Agent Symphony Testing - Part 3
 * </p>
 *
 * @author Symphony Agent
 * @version 1.0.0
 * @since 2026-06-02
 */
public class CalculatorApp {

    private static final Calculator calculator = new Calculator();

    /**
     * Main entry point for the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===========================================");
        System.out.println("  Symphony Addition Calculator");
        System.out.println("  RAP-838: Agent Symphony Testing - Part 3");
        System.out.println("===========================================\n");

        while (true) {
            try {
                System.out.println("\nSelect operation type:");
                System.out.println("1. Add Integers");
                System.out.println("2. Add Decimals (Double)");
                System.out.println("3. Add Large Numbers (Long)");
                System.out.println("4. Exit");
                System.out.print("\nEnter your choice (1-4): ");

                int choice = scanner.nextInt();

                if (choice == 4) {
                    System.out.println("\nThank you for using Symphony Calculator!");
                    break;
                }

                switch (choice) {
                    case 1:
                        addIntegers(scanner);
                        break;
                    case 2:
                        addDoubles(scanner);
                        break;
                    case 3:
                        addLongs(scanner);
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 1-4.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter numeric values.");
                scanner.nextLine(); // Clear the buffer
            }
        }

        scanner.close();
    }

    /**
     * Handles integer addition with user input.
     *
     * @param scanner Scanner instance for reading user input
     */
    private static void addIntegers(Scanner scanner) {
        System.out.print("Enter first integer: ");
        int a = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int b = scanner.nextInt();
        
        int result = calculator.add(a, b);
        System.out.println("\nResult: " + a + " + " + b + " = " + result);
    }

    /**
     * Handles double addition with user input.
     *
     * @param scanner Scanner instance for reading user input
     */
    private static void addDoubles(Scanner scanner) {
        System.out.print("Enter first decimal number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second decimal number: ");
        double b = scanner.nextDouble();
        
        double result = calculator.add(a, b);
        System.out.println("\nResult: " + a + " + " + b + " = " + result);
    }

    /**
     * Handles long addition with user input.
     *
     * @param scanner Scanner instance for reading user input
     */
    private static void addLongs(Scanner scanner) {
        System.out.print("Enter first long number: ");
        long a = scanner.nextLong();
        System.out.print("Enter second long number: ");
        long b = scanner.nextLong();
        
        long result = calculator.add(a, b);
        System.out.println("\nResult: " + a + " + " + b + " = " + result);
    }
}
