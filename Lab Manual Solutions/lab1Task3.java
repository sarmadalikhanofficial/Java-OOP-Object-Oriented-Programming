import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class lab1Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // taking input
        System.out.print("Enter original product price: ");
        double originalPrice = input.nextDouble();

        System.out.print("Enter discount percentage: ");
        double discountPercentage = input.nextDouble();

        // calculate discount and final price
        double discountAmount = (discountPercentage / 100) * originalPrice;
        double finalPrice = originalPrice - discountAmount;

        // get current date and time
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        // output
        System.out.println("\nFinal Price after discount: " + finalPrice);
        System.out.println("Transaction Date and Time: " + formattedDateTime);

        input.close();
    }
}
