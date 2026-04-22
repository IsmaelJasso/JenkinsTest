package com.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("=== Demo Console App ===");

        Calculator calc = new Calculator();
        StringUtils utils = new StringUtils();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        if (scanner.hasNextDouble()) {
            double a = scanner.nextDouble();
            System.out.print("Enter another number: ");
            double b = scanner.nextDouble();

            System.out.println("Add:      " + calc.add(a, b));
            System.out.println("Subtract: " + calc.subtract(a, b));
            System.out.println("Multiply: " + calc.multiply(a, b));
            if (b != 0) {
                System.out.println("Divide:   " + calc.divide(a, b));
            }
        }

        System.out.print("Enter a string: ");
        scanner.nextLine(); // consume newline
        String input = scanner.nextLine();
        System.out.println("Reversed:   " + utils.reverse(input));
        System.out.println("Word count: " + utils.wordCount(input));
        System.out.println("Is palindrome: " + utils.isPalindrome(input));

        scanner.close();
    }
}
