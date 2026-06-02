package com.forcepoint.calculator;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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
    
    // Menu choice constants to avoid magic numbers
    private static final int CHOICE_ADD_INTEGERS = 1;
    private static final int CHOICE_ADD_DOUBLES = 2;
    private static final int CHOICE_ADD_LONGS = 3;
    private static final int CHOICE_EXIT = 4;

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
                System.out.println(CHOICE_ADD_INTEGERS + ". Add Integers");
                System.out.println(CHOICE_ADD_DOUBLES + ". Add Decimals (Double)");
                System.out.println(CHOICE_ADD_LONGS + ". Add Large Numbers (Long)");
                System.out.println(CHOICE_EXIT + ". Exit");
                System.out.print("\nEnter your choice (1-4): ");

                int choice = scanner.nextInt();

                if (choice == CHOICE_EXIT) {
                    System.out.println("\nThank you for using Symphony Calculator!");
                    break;
                }

                switch (choice) {
                    case CHOICE_ADD_INTEGERS:
                        addIntegers(scanner);
                        break;
                    case CHOICE_ADD_DOUBLES:
                        addDoubles(scanner);
                        break;
                    case CHOICE_ADD_LONGS:
                        addLongs(scanner);
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter numeric values.");
                scanner.nextLine(); // Clear the buffer
            } catch (NoSuchElementException e) {
                System.out.println("\nInput stream closed. Exiting gracefully.");
                break;
            }
        }

        scanner.close();
    }

    /**
     * Handles integer addition with user input.
     * Includes specific error handling for invalid integer inputs.
     *
     * @param scanner Scanner instance for reading user input
     */
    private static void addIntegers(Scanner scanner) {
        try {
            System.out.print("Enter first integer: ");
            int a = scanner.nextInt();
            System.out.print("Enter second integer: ");
            int b = scanner.nextInt();
            
            int result = calculator.add(a, b);
            System.out.println("\nResult: " + a + " + " + b + " = " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers only.");
            scanner.nextLine(); // Clear buffer
        }
    }

    /**
     * Handles double addition with user input.
     * Includes specific error handling for invalid double inputs.
     *
     * @param scanner Scanner instance for reading user input
     */
    private static void addDoubles(Scanner scanner) {
        try {
            System.out.print("Enter first decimal number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second decimal number: ");
            double b = scanner.nextDouble();
            
            double result = calculator.add(a, b);
            System.out.println("\nResult: " + a + " + " + b + " = " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid decimal numbers only.");
            scanner.nextLine(); // Clear buffer
        }
    }

    /**
     * Handles long addition with user input.
     * Includes specific error handling for invalid long inputs.
     *
     * @param scanner Scanner instance for reading user input
     */
    private static void addLongs(Scanner scanner) {
        try {
            System.out.print("Enter first long number: ");
            long a = scanner.nextLong();
            System.out.print("Enter second long number: ");
            long b = scanner.nextLong();
            
            long result = calculator.add(a, b);
            System.out.println("\nResult: " + a + " + " + b + " = " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid long numbers only.");
            scanner.nextLine(); // Clear buffer
        }
    }
}
