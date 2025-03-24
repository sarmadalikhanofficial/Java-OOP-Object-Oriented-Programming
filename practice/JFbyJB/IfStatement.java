import java.util.Scanner;

// public class SalaryCalculator {
    public class IfStatement {

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
        if (sales > quota) {
            salary = salary + bonus;
        }
        //or
        // if (sales > quota) salary = salary + bonus;

        System.out.println("Employee's salary: " + salary); 
    }
}
