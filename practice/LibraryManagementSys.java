import java.util.Scanner;

public class LibraryManagementSys {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the standard input (keyboard).
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of books.
        System.out.println("Enter the number of books: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character.

        // Create an array to store book titles.
        String[] bookTitles = new String[numBooks];

        // Loop to read book titles from the user.
        for (int i = 0; i < numBooks; i++) {
            System.out.println("Enter the title of book " + (i + 1) + ": ");
            bookTitles[i] = scanner.nextLine(); // Use nextLine() to read the full title.
        }

        // Display the list of books.
        System.out.println("List of books:");
        for (String title : bookTitles) {
            System.out.println(title);
        }

        // Close the scanner object to release the associated resources.
        scanner.close();
    }
}
