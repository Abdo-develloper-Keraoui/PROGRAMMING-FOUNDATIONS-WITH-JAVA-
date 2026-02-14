package Chapter2;
import java.util.Scanner;

public class Exercise2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Hours, Minutes, Seconds, TimeInSeconds, remaining;
        System.out.print("Enter the number of seconds: ");

        TimeInSeconds = scanner.nextInt();

        remaining = TimeInSeconds;

        Hours = remaining / 3600;
        remaining %= 3600;

        Minutes = remaining / 60;
        remaining %= 60;

        Seconds = remaining;

        System.out.println(TimeInSeconds + " seconds -> "
            + Hours + " hours, " + Minutes + " minutes, " + Seconds + " seconds");

        scanner.close();
    }
}
