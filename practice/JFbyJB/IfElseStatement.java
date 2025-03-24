import java.util.Scanner;

// public class SalaryCalculator {
    public class IfElseStatement {

    public static void main(String[] args) {

        // Initialize known values
        int salary = 1000;
        int bonus = 250;
        int quota = 10;

        // Get values for the unknown
        System.out.println("How many sales did the employee make this week?");
        Scanner scanner = new Scanner(System.in);
        int sales = scanner.nextInt();
        scanner.close();

        // Quick detour for the bonus earners
        // For example:
        if (sales >= quota) {
            System.out.println("Congrats! You've met your quota." );
        }
        else{
            int salesShort = quota - sales;
            System.out.println("You did not make your quota. You were " + salesShort + " sales short.");
        }
        



    }
}