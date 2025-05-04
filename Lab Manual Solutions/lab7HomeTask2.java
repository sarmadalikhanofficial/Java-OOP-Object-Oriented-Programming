// Abstract class Employee
abstract class Employee {
    protected String name;
    protected String employeeID;

    // Constructor to initialize name and employeeID
    public Employee(String name, String employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    // Abstract methods for salary calculation and role description
    public abstract double calculateSalary();
    public abstract String getRole();

    // Non-abstract method to display employee details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Role: " + getRole());
        System.out.println("Salary: $" + calculateSalary());
    }
}

// Concrete subclass Manager
class Manager extends Employee {
    private double baseSalary;
    private double bonus;

    // Constructor for Manager
    public Manager(String name, String employeeID, double baseSalary, double bonus) {
        super(name, employeeID);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus; // Manager's salary includes a bonus
    }

    @Override
    public String getRole() {
        return "Manager";
    }
}

// Concrete subclass Developer
class Developer extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    // Constructor for Developer
    public Developer(String name, String employeeID, double hourlyRate, double hoursWorked) {
        super(name, employeeID);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked; // Developer's salary based on hours worked
    }

    @Override
    public String getRole() {
        return "Developer";
    }
}

// Main class to test the implementation
public class lab7HomeTask2 {
    public static void main(String[] args) {
        // Create Manager object
        Manager manager = new Manager("Alice Johnson", "M001", 60000, 5000);
        System.out.println("Manager Details:");
        manager.displayDetails();
        
        System.out.println();

        // Create Developer object
        Developer developer = new Developer("Bob Smith", "D001", 50, 160);  // 160 hours worked
        System.out.println("Developer Details:");
        developer.displayDetails();
    }
}
