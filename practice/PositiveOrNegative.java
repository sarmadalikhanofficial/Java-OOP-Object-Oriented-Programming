//to check if a number is positive, negative or zero
import java.util.Scanner;

//class containing the method
class NumberChecker {
    static void checkNumber(int myNum) {
        if (myNum > 0) {
            System.out.println("The value is a positive number.");
        } else if (myNum < 0) {
            System.out.println("The value is a negative number.");
        } else {
            System.out.println("The value is 0.");
        }
    }
}

//main class 
public class PositiveOrNegative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int number = input.nextInt();
        
        NumberChecker.checkNumber(number);
        
        input.close(); //close the scanner to prevent memory leaks
    }
}
