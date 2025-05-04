// Lab3Task2.java

class Student {
    // Attributes
    String name;
    int rollNumber;
    double[] grades;

    // Constructor to initialize name and roll number
    Student(String name, int rollNumber, double[] grades) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grades = grades;
    }

    // Method to calculate average grade
    double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return grades.length > 0 ? sum / grades.length : 0;
    }

    // Method to display student details
    void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.print("Grades: ");
        for (double grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println("\nAverage Grade: " + calculateAverage());
        System.out.println("-----------------------------");
    }
}

// Main class to demonstrate the Student class
public class lab3Task2 {
    public static void main(String[] args) {
        // Creating student objects
        double[] grades1 = {85.5, 90.0, 78.0};
        double[] grades2 = {88.0, 92.5, 81.5, 76.0};

        Student student1 = new Student("Ali", 101, grades1);
        Student student2 = new Student("Sara", 102, grades2);

        // Displaying student details
        student1.displayStudentDetails();
        student2.displayStudentDetails();
    }
}
