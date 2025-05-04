import java.util.Scanner;

public class lab9HomeTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Accepting two numbers from the user
            System.out.print("Enter the first number: ");
            String num1Str = scanner.nextLine();
            System.out.print("Enter the second number: ");
            String num2Str = scanner.nextLine();
            
            // Convert input strings to double
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            
            // Perform division
            double result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter valid numbers.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
