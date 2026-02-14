import java.util.Scanner;

public class Recap {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //System.out.println(countDigits(150945545));
        //printReverseArray(readIntInRange("Enter the size of the array: ", 1, 10));
        int n = 17;
        System.out.println("isPrime(" + n + ") == " + isPrime(n));
    }

    public static int countDigits(int number) {
        if (number < 0) throw new IllegalArgumentException("Number must be positive");

        if(number == 0) {
            return 1;
        }
        int digitsCounter = 0;
        while(number != 0) {
            number /= 10;
            digitsCounter++;
        }
        return digitsCounter;
    }
    private static int readInt() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("'" + input + "' is not a valid number. Try again.");
            }
        }
    }
    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            int input = readInt();
            if(input < min || input > max) {
                System.out.println("'" + input + "' is not in the valid range [ " + min + ", " + max +
                        " ]. Try again.");
            } else {
                return input;
            }
        }
    }

    public static void printReverseArray(int n) {
        int[] array = new int[n];
        System.out.println("Fill the array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Array[" + (i + 1) + "] = ");
            array[i] = readInt();
        }

        System.out.println("Printing the array in reverse order: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.println("Array[" + (i + 1) + "] = " + array[i]);
        }
    }

    public static boolean isPrime(int number) {
        //checks the 0 and 1
        if(number <= 1) {
            return false;
        }
        //checks 2 and 3
        if(number <= 3) {
            return true;
        }
        //checks all even numbers cuts work in half !!
        if(number % 2 == 0) {
            return false;
        }
        //checks odd numbers
        for(int i = 3; i * i <= number; i += 2) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
