import java.util.Scanner;

public class lab1Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double monday, tuesday, wednesday, thursday, friday, saturday, sunday;
        double totalDistance;

        // user input
        System.out.print("Enter distance run on Monday: ");
        monday = input.nextDouble();

        System.out.print("Enter distance run on Tuesday: ");
        tuesday = input.nextDouble();

        System.out.print("Enter distance run on Wednesday: ");
        wednesday = input.nextDouble();

        System.out.print("Enter distance run on Thursday: ");
        thursday = input.nextDouble();

        System.out.print("Enter distance run on Friday: ");
        friday = input.nextDouble();

        System.out.print("Enter distance run on Saturday: ");
        saturday = input.nextDouble();

        System.out.print("Enter distance run on Sunday: ");
        sunday = input.nextDouble();

        // calculate total distance
        totalDistance = monday + tuesday + wednesday + thursday + friday + saturday + sunday;

        // output
        System.out.println("\nTotal distance run over the week: " + totalDistance + " km");

        input.close();
    }
}
