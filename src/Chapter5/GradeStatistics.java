package Chapter5;

import java.util.Scanner;

public class GradeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] grades = new double[6];

        System.out.println("Enter grades: ");

        for(int i = 0; i < 6; i++) {
            System.out.print("Enter grade[ " + (i + 1) + " ] =  " );
            grades[i] = scanner.nextDouble();
        }

        double max = grades[0];
        double min = grades[0];
        double sum = 0;

        for(double val: grades) {
            if(val > max) {
                max = val;
            }
            if(val < min) {
                min = val;
            }
            sum += val;
        }
        System.out.println("Highest grade: " + max);
        System.out.println("Lowest grade: " + min);
        System.out.println("Average grade: " + (sum/grades.length));
        scanner.close();
    }
}
