// Import the Scanner class from the java.util package to read input from the console
import java.util.Scanner;

// The QuadraticEq class serves as the main class of this program.
// It encapsulates the logic for solving a quadratic equation.
public class QuadraticEq {

    // The main method is the entry point of the Java application.
    // It defines the program execution process.
    public static void main(String[] args) {

        // Create a Scanner object to read input from the standard input (keyboard).
        // This object is an instance of the Scanner class.
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the coefficient 'a' of the quadratic equation.
        // The next double value entered by the user is stored in the variable 'a'.
        System.out.println("Enter the coefficient a: ");
        double a = scanner.nextDouble();

        // Prompt the user to enter the coefficient 'b' of the quadratic equation.
        // The next double value entered by the user is stored in the variable 'b'.
        System.out.println("Enter the coefficient b: ");
        double b = scanner.nextDouble();

        // Prompt the user to enter the coefficient 'c' of the quadratic equation.
        // The next double value entered by the user is stored in the variable 'c'.
        System.out.println("Enter the coefficient c: ");
        double c = scanner.nextDouble();

        // Calculate the discriminant of the quadratic equation: b^2 - 4ac.
        double discriminant = (b * b) - (4 * a * c);

        // If the discriminant is positive, the equation has two distinct real roots.
        if (discriminant > 0) {
            // Create two variables for storing the two real roots calculated using the quadratic formula.
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The roots are real and distinct:");
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);

        // If the discriminant is zero, the equation has exactly one real root (a repeated root).
        } else if (discriminant == 0) {
            // Create a variable for storing the repeated real root.
            double root = -b / (2 * a);
            System.out.println("The roots are real and equal:");
            System.out.println("Root: " + root);

        // If the discriminant is negative, the equation has two complex (imaginary) roots.
        } else {
            // Calculate the real part of the complex roots.
            double realPart = -b / (2 * a);
            // Calculate the imaginary part of the complex roots.
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("The roots are complex and imaginary:");
            System.out.println("Root 1: " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root 2: " + realPart + " - " + imaginaryPart + "i");
        }

        // Close the scanner object to release the associated resources.
        scanner.close();
    }
}
