package Chapter3;
/*
 * Exercise 3.1 — Write a program that asks the user for an integer
 * and says whether it is positive, negative, or zero.
 * */
import java.util.Scanner;

public class Exercise3_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Number;
        System.out.println("Please enter an integer: ");
        Number = scanner.nextInt();

        String response = "The Number " + Number + " is ";
        if(Number > 0) {
            response += "Positive";
        } else if (Number < 0){
            response += "Negative";
        } else {
            response += "Zero";
        }

        System.out.println(response);

        scanner.close();


    }
}
