package Chapter2;
import java.util.Scanner;

public class Exercise2_1 {
    public static void main(String[] args) {
        /***
         * Write a program that asks the user for two integers
         * and prints their sum, difference, product, quotient, and remainder.
         */
        Scanner scanner = new Scanner(System.in);
        int number1, number2;
        System.out.println("Enter number 1: ");
        number1 = scanner.nextInt();
        System.out.println("Enter number 2: ");
        number2 = scanner.nextInt();

        System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
        System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
        System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
        if(number2 != 0) {
            System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
            System.out.println(number1 + " % " + number2 + " = " + (number1 % number2));
        } else {
            System.out.println("Cannot divide by zero!");
        }

        scanner.close();
    }
}
