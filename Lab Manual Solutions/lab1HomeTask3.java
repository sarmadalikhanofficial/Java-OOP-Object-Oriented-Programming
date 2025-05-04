import java.util.Date;
import java.util.Scanner;

public class HomeTask3 {
    public static void main(String[] args) {
        // 1. CURRENT DATE AND TIME
        Date currentDate = new Date();
        System.out.println("Current Date and Time: " + currentDate);

        // 2. MATH OPERATIONS
        Scanner input = new Scanner(System.in);
        
        System.out.print("\nEnter a number: ");
        double number = input.nextDouble();

        System.out.print("Enter an exponent: ");
        double exponent = input.nextDouble();

        double sqrt = Math.sqrt(number);
        double sin = Math.sin(Math.toRadians(number));  // Converting degrees to radians
        double cos = Math.cos(Math.toRadians(number));
        double tan = Math.tan(Math.toRadians(number));
        double power = Math.pow(number, exponent);
        double random = Math.random();

        // 3. FORMATTED OUTPUT
        System.out.println("\n--- Math Operations ---");
        System.out.printf("Square root of %.2f: %.4f%n", number, sqrt);
        System.out.printf("Sine of %.2f degrees: %.4f%n", number, sin);
        System.out.printf("Cosine of %.2f degrees: %.4f%n", number, cos);
        System.out.printf("Tangent of %.2f degrees: %.4f%n", number, tan);
        System.out.printf("%.2f raised to the power %.2f: %.4f%n", number, exponent, power);
        System.out.printf("Random number between 0 and 1: %.4f%n", random);

        input.close();
    }
}
