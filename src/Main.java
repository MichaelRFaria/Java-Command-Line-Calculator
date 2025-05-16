import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // ArrayList over ArrayDeque to easily traverse the entire structure
    static ArrayList<Integer> operands = new ArrayList<>();
    static ArrayList<Character> operations = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Command Line Calculator");
        System.out.println("This calculator works by inputting a sequence of numbers and operations");
        System.out.println("Inputting '+', '-', '*' or '/' will carry out the associated operation");
        System.out.println("Inputting '!' as an operation will halt the program");
        System.out.println("Inputting '=' will calculate the result of the last portion of your expression");
        System.out.println("Inputting '==' will calculate the entire expression\n");

        while (true) {
            operand();
            output();
            operation();
        }
    }

    public static void operand() {
        System.out.print("Please input a number: ");
        int num;
        boolean valid = false;

        while (!valid) {
            try {
                num = scanner.nextInt();
                operands.add(num);
                valid = true;
            } catch (InputMismatchException e) {
                System.out.print("Please input an integer, try again: ");
                scanner.next();
            }
        }
    }

    public static void operation() {
        System.out.print("\nPlease input an operation: ");
        char op;
        boolean valid = false;

        while (!valid) {
            String check = scanner.next();
            if (check.equals("==")) {
                while (!operations.isEmpty()) {equals(); }
                output();
                operation(); // recursive call
                break;
            } else if (check.length() > 1) {
                System.out.print("Please input an operation, try again: ");
                continue;
            } else {op = check.charAt(0); }

            switch (op) {
                case '+', '-', '*', '/':
                    operations.add(op);
                    valid = true;
                    break;
                case '=':
                    equals();
                    output();
                    operation(); // recursive call
                    valid = true;
                    break;
                case '!':
                    System.out.println("\nThank you for using the Command Line Calculator!\nGoodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.print("Please input an operation, try again: ");
                    break;
            }
        }
    }

    public static void output() {
        int end = operands.size() - 1;
        System.out.print("Your expression is: ");

        System.out.print(operands.get(0) + " ");
        for (int i = 0; i < end; i++) {
            System.out.print(operations.get(i) + " ");
            System.out.print(operands.get(i + 1) + " ");
        }
    }

    public static void equals() {
        try {
            int num2 = operands.get(operands.size() - 1);
            int num1 = operands.get(operands.size() - 2);
            char op = operations.get(operations.size() - 1);

            operands.remove(operands.size() - 1);
            operands.remove(operands.size() - 1);
            operations.remove(operations.size() - 1);

            switch (op) {
                case '+':
                    operands.add(num1 + num2);
                    break;
                case '-':
                    operands.add(num1 - num2);
                    break;
                case '*':
                    operands.add(num1 * num2);
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Cannot divide by zero");
                        operands.add(num1);
                        operands.add(num2);
                        operations.add(op);
                    } else {operands.add(num1 / num2); }
                    break;
                default:
                    System.out.println(op);
                    throw new RuntimeException("Unexpected operator");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please add more operands: ");
        }
    }
}
