package Chapter2;
import java.util.Scanner;

public class Exercise2_2 {
    public static void main(String[] args) {
        /***
         *  Write a program that converts a temperature from Celsius to Fahrenheit.
         *  Formula: `F = C × 9/5 + 32`. The user enters Celsius as a decimal number.
         */
        Scanner scanner = new Scanner(System.in);
        double Celsius, Fahrenheit;
        System.out.println("Enter temperature in Celsius: ");
        Celsius = scanner.nextDouble();
        Fahrenheit = Celsius * (9.0/5.0) + 32;
        System.out.println(Celsius + " C°   =   " + Fahrenheit + " F°");

        scanner.close();
    }
}
