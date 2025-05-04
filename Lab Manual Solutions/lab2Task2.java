public class lab2Task2 {
    public static void main(String[] args) {
        int sum = 0;

        // loop from 1 to 100
        for (int i = 1; i <= 100; i++) {
            // check if number is even
            if (i % 2 == 0) {
                sum += i; // add even number to sum
            }
        }

        // print the result
        System.out.println("The sum of all even numbers from 1 to 100 is: " + sum);
    }
}
