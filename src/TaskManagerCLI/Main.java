package TaskManagerCLI;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskDone();
                case 4 -> {
                    System.out.println("Goodbye.");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== TASK MANAGER =====");
        System.out.println("1. Add a task");
        System.out.println("2. View all tasks");
        System.out.println("3. Mark task as done");
        System.out.println("4. Quit");
        System.out.print("Choose an option: ");
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
            System.out.println(prompt);
            int input = readInt();
            if(input < min || input > max) {
                System.out.println("'" + input + "' is not in the valid range [ " + min + ", " + max +
                        " ]. Try again.");
            } else {
                return input;
            }
        }
    }
    private static String readNonEmptyString() {
        while (true) {
            String input = scanner.nextLine().trim();
            if(!input.isEmpty()) {
                return input;
            }
            System.out.println("'" + input + "' cannot be empty. Try again.");
        }
    }

    private static void addTask() {
        System.out.print("\nEnter Task Title: ");
        String title = readNonEmptyString();
        Task task = new Task(title);
        tasks.add(task);
    }

    private static void viewTasks() {
        if(tasks.isEmpty()) {
            System.out.println("No tasks have been found!");
            return;
        }
        System.out.println("Your tasks: ");

        int taskIndex = 0;
        for(Task task: tasks) {
            taskIndex++;
            System.out.println("Task(" + taskIndex + ") = " + task);
        }
    }

    private static void markTaskDone() {
        viewTasks();
        if(tasks.isEmpty()) {
            return;
        }
        int taskNumber = readIntInRange("\nEnter task number: ", 1, tasks.size());
        Task task = tasks.get(taskNumber - 1);
        if(task.isDone()) {
            System.out.println("Task already done!");
        } else {
            task.markAsDone();
        }
    }
}