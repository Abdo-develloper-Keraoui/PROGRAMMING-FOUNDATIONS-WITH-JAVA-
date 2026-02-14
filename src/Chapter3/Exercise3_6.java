package Chapter3;

import java.util.Scanner;
import java.util.Random;
/*
* Write a number guessing game. The program picks a random number between 1 and 100, and the user guesses.
* After each guess, say "Higher" or "Lower". Count the number of attempts.*/

public class Exercise3_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int Goal = random.nextInt(100) + 1;//numbers from 1 to 99 ( +1 )
        int UserInput;
        int NumberOfAttempts = 0;
        System.out.println("I picked a number between 1 and 100. Guess it!");

        do {
            System.out.print("Enter your guess: ");
            UserInput = scanner.nextInt();
            System.out.println("");
            NumberOfAttempts++;

            if(Goal > UserInput) {
                System.out.println("Higher");
            } else if(Goal < UserInput) {
                System.out.println("Lower");
            }
        } while(UserInput != Goal);

        System.out.println("The correct guess was: " + Goal);
        System.out.println("You found it in " + NumberOfAttempts + " guess(es)");

        scanner.close();
    }
}
