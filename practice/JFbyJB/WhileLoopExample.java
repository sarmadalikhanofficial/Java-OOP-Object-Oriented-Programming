import java.util.Scanner;

public class WhileLoopExample {
    /**
     * This program calculates the gross pay of an employee based on their hours worked.
     * It ensures that the hours worked are within a valid range (1 to 40).
     * If the input is invalid, it prompts the user to enter a valid number of hours.
     */

    public static void main(String[] args) {

        // Initialize known variables
        int payRate = 15;
        int maxHours = 40;

        // Get input for unknown variables
        System.out.println("How many hours did the employee work this week?");
        Scanner scanner = new Scanner(System.in);
        double hoursWorked = scanner.nextDouble();

        // Validate input
        while (hoursWorked > maxHours || hoursWorked < 1) {
            System.out.println("Invalid entry. Your hours must be between 1 and 40. Try again.");
            hoursWorked = scanner.nextDouble();
        }

        scanner.close();

        // Calculate gross
        double gross = payRate * hoursWorked;

        // Output gross pay
        System.out.println("Gross pay: $" + gross);
    }
}