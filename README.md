# Symphony Test Project

A comprehensive testing project containing multiple calculator implementations for Symphony Agent testing.

## Overview

This repository contains two calculator implementations:
1. **HTML/JavaScript Calculator** (RAP-837) - Web-based calculator with multiple mathematical operations
2. **Java Calculator** (RAP-838) - Command-line calculator with addition functionality

---

## 🌐 HTML/JavaScript Calculator (RAP-837)

**Jira Story**: RAP-837 - Create a sample HTML page which will perform mathematical operation using JavaScript

### Features

- **Multiple Operations**: Addition, Subtraction, Multiplication, and Division
- **Modern UI**: Gradient design with smooth animations
- **Real-time Validation**: Input validation with error handling
- **Responsive Design**: Works on desktop and mobile devices
- **Division by Zero Protection**: Prevents invalid division operations
- **Keyboard Support**: Calculate using Enter key
- **Clear Functionality**: Reset all inputs and results

### Files

- `calculator.html` - Main HTML page with embedded styles
- `calculator.js` - JavaScript implementation of mathematical operations

### Usage

#### Option 1: Direct File Opening
1. Open `calculator.html` in any modern web browser
2. Enter two numbers in the input fields
3. Select an operation (Add, Subtract, Multiply, Divide)
4. Click "Calculate Result" or press Enter
5. View the result displayed below

#### Option 2: Local Web Server
```bash
# Using Python 3
python -m http.server 8000

# Using Node.js http-server (install first: npm install -g http-server)
http-server

# Then open http://localhost:8000/calculator.html
```

### JavaScript Functions

- `add(a, b)` - Adds two numbers
- `subtract(a, b)` - Subtracts b from a
- `multiply(a, b)` - Multiplies two numbers
- `divide(a, b)` - Divides a by b (with zero-division check)
- `formatResult(result)` - Formats numbers with proper precision and localization
- `clearCalculator()` - Resets all inputs and results

### Example Operations

```
Addition:       15 + 27 = 42
Subtraction:    50 - 12 = 38
Multiplication: 6 × 7 = 42
Division:       100 ÷ 4 = 25
```

### Error Handling

- **Invalid Input**: Shows "Please enter valid numbers"
- **Division by Zero**: Shows "Cannot divide by zero"
- **Auto-clear**: Error styling clears after 3 seconds

---

## ☕ Java Calculator (RAP-838)

**Jira Story**: RAP-838 - Agent Symphony Testing - Part 3

A Java application for adding two numbers with comprehensive test coverage.

### Features

- **Multiple Number Types**: Supports addition of integers, doubles, and long numbers
- **Interactive CLI**: User-friendly command-line interface for manual testing
- **Comprehensive Testing**: 20+ JUnit tests covering:
  - Positive and negative numbers
  - Zero handling
  - Decimal precision
  - Boundary conditions
  - Overflow behavior
  - Parameterized tests
- **Production-Ready**: Complete error handling and input validation
- **Enhanced Error Messages**: Specific error messages for each data type

### Project Structure

```
SymphonyTest/
├── calculator.html              # HTML calculator (RAP-837)
├── calculator.js                # JavaScript implementation (RAP-837)
├── pom.xml                      # Maven configuration
├── README.md                    # This file
├── .gitignore                   # Git ignore rules
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

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Building the Java Project

#### Compile the code
```bash
mvn compile
```

#### Run all tests
```bash
mvn test
```

#### Package as JAR
```bash
mvn clean package
```

The executable JAR will be created in `target/symphony-addition-1.0.0.jar`.

### Running the Java Application

#### Using Maven
```bash
mvn exec:java -Dexec.mainClass="com.forcepoint.calculator.CalculatorApp"
```

#### Using the JAR file
```bash
java -cp target/symphony-addition-1.0.0.jar com.forcepoint.calculator.CalculatorApp
```

### Usage Example (Java CLI)

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

### Test Coverage

The Java test suite includes:
- **Integer Tests**: 6 test cases covering positive, negative, zero, overflow, and parameterized scenarios
- **Double Tests**: 6 test cases covering decimals, precision, and mixed values
- **Long Tests**: 5 test cases covering large numbers and overflow
- **Parameterized Tests**: Multiple scenarios tested with various input combinations

#### Running Specific Tests
```bash
# Run all tests
mvn test

# Run with verbose output
mvn test -DtrimStackTrace=false

# Run specific test class
mvn test -Dtest=CalculatorTest
```

### Java API Documentation

#### Calculator Class Methods:
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

---

## Development Information

### RAP-837 (HTML/JavaScript Calculator)
- **Status**: In Progress
- **Implementation**: HTML + JavaScript
- **Features**: Addition, Subtraction, Multiplication, Division

### RAP-838 (Java Calculator)
- **Status**: Code Review Fixed
- **Subtask**: RAP-839
- **Testing Framework**: JUnit 5.9.3
- **Java Version**: 11

### Repository Information
- **Repository**: https://github.com/moreharshal/SymphonyTest
- **Branch**: RAP-838-1

---

## Manual Verification Steps

### HTML Calculator (RAP-837)
1. Open `calculator.html` in a web browser
2. Test addition: 15 + 27 = 42 ✓
3. Test subtraction: 50 - 12 = 38 ✓
4. Test multiplication: 6 × 7 = 42 ✓
5. Test division: 100 ÷ 4 = 25 ✓
6. Test division by zero: Should show error ✓
7. Test clear button: Should reset all fields ✓

### Java Calculator (RAP-838)
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

---

## Code Review Updates

### Version 1.1 - Code Review Fixes Applied (2026-06-02)

The following improvements were made based on code review feedback:

1. ✅ **Enhanced Error Handling**
   - Added specific `InputMismatchException` handling in all helper methods
   - Improved error messages for better user experience
   - Each data type now has its own specific error message

2. ✅ **Removed Magic Numbers**
   - Added constants for menu choices (CHOICE_ADD_INTEGERS, etc.)
   - Improved code maintainability and readability

3. ✅ **Repository Cleanup**
   - Added `.push-marker` to `.gitignore`
   - Cleaned up testing artifacts

All code review comments have been addressed and the code is ready for merge.

---

## License

Internal Forcepoint project for testing purposes.

## Contact

For questions or issues:
- **RAP-837**: HTML/JavaScript Calculator
- **RAP-838**: Java Calculator
- Refer to respective Jira stories for more details
