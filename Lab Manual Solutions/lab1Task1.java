import java.util.Scanner;

public class lab1Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ask for first name
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        // ask for last name
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        // ask for age
        System.out.print("Enter your age: ");
        int age = input.nextInt();

        // calculate age in 5 years
        int futureAge = age + 5;

        // display welcome message
        System.out.println("\nWelcome, " + firstName + " " + lastName + "!");
        System.out.println("In 5 years, you will be " + futureAge + " years old.");

        input.close();
    }
}
