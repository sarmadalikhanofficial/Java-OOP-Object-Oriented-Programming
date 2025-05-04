import java.util.Scanner;

public class lab2Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // prompt user to enter exam score
        System.out.print("Enter your exam score: ");
        int score = input.nextInt();

        // check if score is 50 or above
        if (score >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
