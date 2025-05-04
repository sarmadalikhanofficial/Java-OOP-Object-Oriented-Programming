import java.util.Random;
import java.util.Scanner;

public class lab2HomeTask3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            // Generate random secret number between 1 and 100
            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 7; // Set max attempts
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            // Game loop
            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();

                // Validate guess
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                    attempts--; // Do not count this as a valid attempt
                    continue;
                }

                if (userGuess > secretNumber) {
                    System.out.println("Too high!");
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    break;
                }
            }

            // If the user runs out of attempts without guessing correctly
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The secret number was " + secretNumber + ".");
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (y/n): ");
            String playAgain = scanner.next().toLowerCase();

            if (playAgain.equals("n")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }
        }

        scanner.close();
    }
}
