# Symphony Addition Calculator

A sample Java application for adding two numbers, created as part of **RAP-838: Agent Symphony Testing - Part 3**.

## Overview

This project implements a simple calculator with addition functionality for different numeric types (int, double, long). It includes:
- Core calculator logic with comprehensive Javadoc
- Interactive command-line interface (CLI) for manual testing
- Extensive JUnit 5 test suite with 20+ test cases
- Maven-based project structure for easy building and testing

## Features

- **Multiple Number Types**: Supports addition of integers, doubles, and long numbers
- **Interactive CLI**: User-friendly interface for manual testing
- **Comprehensive Testing**: 20+ JUnit tests covering:
  - Positive and negative numbers
  - Zero handling
  - Decimal precision
  - Boundary conditions
  - Overflow behavior
  - Parameterized tests
- **Production-Ready**: Complete error handling and input validation

## Project Structure

```
SymphonyTest/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── forcepoint/
    │               └── calculator/
    │                   ├── Calculator.java        # Core addition logic
    │                   └── CalculatorApp.java     # CLI application
    └── test/
        └── java/
            └── com/
                └── forcepoint/
                    └── calculator/
                        └── CalculatorTest.java    # JUnit test suite
```

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Building the Project

### Compile the code
```bash
mvn compile
```

### Run all tests
```bash
mvn test
```

### Package as JAR
```bash
mvn clean package
```

The executable JAR will be created in `target/symphony-addition-1.0.0.jar`.

## Running the Application

### Using Maven
```bash
mvn exec:java -Dexec.mainClass="com.forcepoint.calculator.CalculatorApp"
```

### Using the JAR file
```bash
java -cp target/symphony-addition-1.0.0.jar com.forcepoint.calculator.CalculatorApp
```

## Usage Example

When you run the application, you'll see an interactive menu:

```
===========================================
  Symphony Addition Calculator
  RAP-838: Agent Symphony Testing - Part 3
===========================================

Select operation type:
1. Add Integers
2. Add Decimals (Double)
3. Add Large Numbers (Long)
4. Exit

Enter your choice (1-4): 1
Enter first integer: 15
Enter second integer: 27

Result: 15 + 27 = 42
```

## Test Coverage

The test suite includes:
- **Integer Tests**: 6 test cases covering positive, negative, zero, overflow, and parameterized scenarios
- **Double Tests**: 6 test cases covering decimals, precision, and mixed values
- **Long Tests**: 5 test cases covering large numbers and overflow
- **Parameterized Tests**: Multiple scenarios tested with various input combinations

### Running Specific Tests
```bash
# Run all tests
mvn test

# Run with verbose output
mvn test -DtrimStackTrace=false

# Run specific test class
mvn test -Dtest=CalculatorTest
```

## API Documentation

### Calculator Class

#### Methods:
- `int add(int a, int b)` - Adds two integers
- `double add(double a, double b)` - Adds two doubles
- `long add(long a, long b)` - Adds two long numbers

#### Example Usage:
```java
Calculator calc = new Calculator();

// Integer addition
int sum1 = calc.add(5, 3);  // Returns 8

// Double addition
double sum2 = calc.add(5.5, 3.2);  // Returns 8.7

// Long addition
long sum3 = calc.add(1000000000L, 2000000000L);  // Returns 3000000000L
```

## Development Information

- **Jira Story**: RAP-838
- **Subtask**: RAP-839
- **Repository**: https://github.com/moreharshal/SymphonyTest
- **Branch**: RAP-838-1
- **Java Version**: 11
- **Testing Framework**: JUnit 5.9.3

## Manual Verification Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/moreharshal/SymphonyTest.git
   cd SymphonyTest
   git checkout RAP-838-1
   ```

2. Run tests to verify functionality:
   ```bash
   mvn test
   ```
   Expected: All 20+ tests should pass

3. Build the project:
   ```bash
   mvn clean package
   ```
   Expected: BUILD SUCCESS

4. Run the CLI application:
   ```bash
   java -cp target/symphony-addition-1.0.0.jar com.forcepoint.calculator.CalculatorApp
   ```
   Expected: Interactive menu appears

5. Test various scenarios:
   - Add positive integers (e.g., 15 + 27)
   - Add negative numbers (e.g., -10 + -5)
   - Add decimals (e.g., 3.14 + 2.86)
   - Add large numbers (e.g., 1000000000 + 2000000000)

## License

Internal Forcepoint project for testing purposes.

## Contact

For questions or issues, please refer to RAP-838 in Jira.
