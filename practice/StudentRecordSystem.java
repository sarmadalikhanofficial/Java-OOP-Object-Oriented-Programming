import java.util.Scanner;

class Student {
    // fields
    private String name;
    private int roll;
    private double marks;

    // constructor
    public Student(String name, int roll, double marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    // getters
    public int getRoll() {
        return roll;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + roll);
        System.out.println("Marks: " + marks);
        System.out.println("---------------------");
    }
}

public class StudentRecordSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student[] students = new Student[100]; // max 100 students
        int count = 0;

        while (true) {
            System.out.println("\nSTUDENT RECORD SYSTEM");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter name: ");
                input.nextLine(); // consume leftover newline
                String name = input.nextLine();

                System.out.print("Enter roll number: ");
                int roll = input.nextInt();

                System.out.print("Enter marks: ");
                double marks = input.nextDouble();

                students[count] = new Student(name, roll, marks);
                count++;
                System.out.println("Student added successfully!");

            } else if (choice == 2) {
                System.out.println("\n--- All Student Records ---");
                for (int i = 0; i < count; i++) {
                    students[i].displayInfo();
                }

            } else if (choice == 3) {
                System.out.print("Enter roll number to search: ");
                int rollSearch = input.nextInt();
                boolean found = false;

                for (int i = 0; i < count; i++) {
                    if (students[i].getRoll() == rollSearch) {
                        students[i].displayInfo();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }

            } else if (choice == 4) {
                System.out.println("Exiting... 👋");
                break;

            } else {
                System.out.println("Invalid option. Try again!");
            }
        }

        input.close();
    }
}
