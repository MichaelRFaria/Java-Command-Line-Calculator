# Command Line Calculator

A simple command-line calculator written in Java.  
This program allows users to input numbers and operations sequentially and evaluate parts or all of the expression interactively.

## 💡 How It Works

- Input a number when prompted.
- Then input an operation (`+`, `-`, `*`, or `/`).
- Repeat this process to build up an expression.

## ✏️ Commands

- `+`, `-`, `*`, `/` → Adds the operation to the expression.
- `=` → Evaluates the **last two operands and last operator**.
- `==` → Evaluates the **entire expression** from right to left.
- `!` → Exits the program.

## 🖥️ Example

```text
Welcome to the Command Line Calculator
This calculator works by inputting a sequence of numbers and operations
Inputting '+', '-', '*' or '/' will carry out the associated operation
Inputting '!' as an operation will halt the program
Inputting '=' will calculate the result of the last portion of your expression
Inputting '==' will calculate the entire expression

Please input a number: 5
Your expression is: 5 
Please input an operation: +
Please input a number: 3
Your expression is: 5 + 3 
Please input an operation: *
Please input a number: 2
Your expression is: 5 + 3 * 2 
Please input an operation: +
Please input a number: 7
Your expression is: 5 + 3 * 2 + 7 
Please input an operation: =
Your expression is: 5 + 3 * 9 
Please input an operation: ==
Your expression is: 32 
Please input an operation: !

Thank you for using the Command Line Calculator!
Goodbye!
