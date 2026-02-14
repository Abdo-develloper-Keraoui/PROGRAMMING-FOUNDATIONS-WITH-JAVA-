package Chapter4;
/*
* Write a method factorial(int n) that returns n! (n factorial).
* Use a loop, not recursion. Handle the case where n is 0 (0! = 1).*/

public class Exercise4_2 {
    public static int factorial(int n) {
        if(n < 0) {
            return -1;
        }
        //we can specify for understandability and comprehension
        if(n == 0 || n == 1) {
            return 1;
        }
        int result = 1;
        for(int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(n + "! = " + factorial(n));
        long maxLong = Long.MAX_VALUE;
        double maxDouble = Double.MAX_VALUE;
        System.out.println("Max double value: " + maxDouble);
/*
        for(int i = 20; i <= 50; i++) {
            if(factorial(i) < 0) {
                System.out.println(i + " is where the limit");
                break;
            }
        }
        */
    }
}
