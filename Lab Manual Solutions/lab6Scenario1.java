// Base class
class Employee {
    String name;
    int id;
    double salary;

    // Constructor
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
        this.salary = 0.0; // default, calculated later
    }

    // Method to be overridden
    double calculateSalary() {
        return salary;
    }

    // To display employee info
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: $" + calculateSalary());
        System.out.println("-------------------------");
    }
}

// Full-time employee class
class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

// Part-time employee class
class PartTimeEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Contract employee class
class ContractEmployee extends Employee {
    double dailyRate;
    int daysWorked;

    ContractEmployee(String name, int id, double dailyRate, int daysWorked) {
        super(name, id);
        this.dailyRate = dailyRate;
        this.daysWorked = daysWorked;
    }

    @Override
    double calculateSalary() {
        return dailyRate * daysWorked;
    }
}

// Main class
public class lab6Scenario1 {
    public static void main(String[] args) {
        // Creating employees
        FullTimeEmployee emp1 = new FullTimeEmployee("Alice", 101, 5000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Bob", 102, 20, 80);
        ContractEmployee emp3 = new ContractEmployee("Charlie", 103, 150, 22);

        // Displaying employee info
        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();
    }
}
