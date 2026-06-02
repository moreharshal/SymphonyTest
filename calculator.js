/**
 * Symphony Calculator JavaScript
 * RAP-837: Mathematical Operations Implementation
 * 
 * @author Symphony Agent
 * @version 1.0.0
 * @since 2026-06-02
 */

// Global state for selected operation
let selectedOperation = 'add';

/**
 * Initializes the calculator application
 */
function initCalculator() {
    // Get DOM elements
    const form = document.getElementById('calculatorForm');
    const calculateBtn = document.getElementById('calculateBtn');
    const clearBtn = document.getElementById('clearBtn');
    const operationButtons = document.querySelectorAll('.operation-btn');
    const number1Input = document.getElementById('number1');
    const number2Input = document.getElementById('number2');
    const resultContainer = document.getElementById('resultContainer');
    const resultValue = document.getElementById('resultValue');

    // Set up operation button listeners
    operationButtons.forEach(button => {
        button.addEventListener('click', function() {
            // Remove active class from all buttons
            operationButtons.forEach(btn => btn.classList.remove('active'));
            
            // Add active class to clicked button
            this.classList.add('active');
            
            // Update selected operation
            selectedOperation = this.getAttribute('data-operation');
        });
    });

    // Handle form submission
    form.addEventListener('submit', handleCalculation);
    calculateBtn.addEventListener('click', handleCalculation);

    // Handle clear button
    clearBtn.addEventListener('click', clearCalculator);

    // Handle Enter key press
    number1Input.addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            e.preventDefault();
            handleCalculation();
        }
    });

    number2Input.addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            e.preventDefault();
            handleCalculation();
        }
    });
}

/**
 * Handles the calculation operation
 * @param {Event} event - The event object
 */
function handleCalculation(event) {
    if (event) {
        event.preventDefault();
    }

    // Get input values
    const number1 = parseFloat(document.getElementById('number1').value);
    const number2 = parseFloat(document.getElementById('number2').value);

    // Validate inputs
    if (isNaN(number1) || isNaN(number2)) {
        showError('Please enter valid numbers');
        return;
    }

    // Perform calculation
    let result;
    try {
        result = performOperation(number1, number2, selectedOperation);
        displayResult(result);
    } catch (error) {
        showError(error.message);
    }
}

/**
 * Performs mathematical operation based on selected operation type
 * @param {number} num1 - First number
 * @param {number} num2 - Second number
 * @param {string} operation - Operation type
 * @returns {number} The result of the operation
 */
function performOperation(num1, num2, operation) {
    switch(operation) {
        case 'add':
            return add(num1, num2);
        case 'subtract':
            return subtract(num1, num2);
        case 'multiply':
            return multiply(num1, num2);
        case 'divide':
            return divide(num1, num2);
        default:
            throw new Error('Invalid operation');
    }
}

/**
 * Adds two numbers
 * @param {number} a - First number
 * @param {number} b - Second number
 * @returns {number} Sum of a and b
 */
function add(a, b) {
    return a + b;
}

/**
 * Subtracts second number from first number
 * @param {number} a - First number
 * @param {number} b - Second number
 * @returns {number} Difference of a and b
 */
function subtract(a, b) {
    return a - b;
}

/**
 * Multiplies two numbers
 * @param {number} a - First number
 * @param {number} b - Second number
 * @returns {number} Product of a and b
 */
function multiply(a, b) {
    return a * b;
}

/**
 * Divides first number by second number
 * @param {number} a - First number (dividend)
 * @param {number} b - Second number (divisor)
 * @returns {number} Quotient of a divided by b
 * @throws {Error} If divisor is zero
 */
function divide(a, b) {
    if (b === 0) {
        throw new Error('Cannot divide by zero');
    }
    return a / b;
}

/**
 * Displays the calculation result
 * @param {number} result - The calculation result
 */
function displayResult(result) {
    const resultContainer = document.getElementById('resultContainer');
    const resultValue = document.getElementById('resultValue');

    // Format the result (limit decimal places for better display)
    const formattedResult = formatResult(result);

    resultValue.textContent = formattedResult;
    resultContainer.classList.add('show');

    // Remove any error styling
    document.getElementById('number1').classList.remove('error');
    document.getElementById('number2').classList.remove('error');
}

/**
 * Formats the result for display
 * @param {number} result - The raw result
 * @returns {string} Formatted result string
 */
function formatResult(result) {
    // Handle special cases
    if (!isFinite(result)) {
        return 'Infinity';
    }
    
    // Round to 10 decimal places to avoid floating point precision issues
    const rounded = Math.round(result * 10000000000) / 10000000000;
    
    // Format with commas for large numbers
    if (Math.abs(rounded) >= 1000) {
        return rounded.toLocaleString('en-US', { maximumFractionDigits: 10 });
    }
    
    return rounded.toString();
}

/**
 * Shows error message
 * @param {string} message - Error message to display
 */
function showError(message) {
    const resultContainer = document.getElementById('resultContainer');
    const resultValue = document.getElementById('resultValue');

    resultValue.textContent = '⚠️ ' + message;
    resultContainer.classList.add('show');

    // Add error styling to inputs
    document.getElementById('number1').classList.add('error');
    document.getElementById('number2').classList.add('error');

    // Remove error styling after 3 seconds
    setTimeout(() => {
        document.getElementById('number1').classList.remove('error');
        document.getElementById('number2').classList.remove('error');
    }, 3000);
}

/**
 * Clears all calculator inputs and results
 */
function clearCalculator() {
    // Clear input fields
    document.getElementById('number1').value = '';
    document.getElementById('number2').value = '';

    // Hide result container
    const resultContainer = document.getElementById('resultContainer');
    resultContainer.classList.remove('show');

    // Reset to addition operation
    document.querySelectorAll('.operation-btn').forEach(btn => {
        btn.classList.remove('active');
        if (btn.getAttribute('data-operation') === 'add') {
            btn.classList.add('active');
        }
    });
    selectedOperation = 'add';

    // Remove error styling
    document.getElementById('number1').classList.remove('error');
    document.getElementById('number2').classList.remove('error');

    // Focus on first input
    document.getElementById('number1').focus();
}

// Initialize calculator when DOM is loaded
document.addEventListener('DOMContentLoaded', initCalculator);
