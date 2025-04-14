// Example 2: Employee Salary using Inheritance
// Scenario:
// Base class: Employee

// Derived class: SalaryEmployee that includes salary details.

package examprep;


// Base class
class Employee {
    int empId;
    String name;

    void inputEmployee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    void displayEmployee() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
    }
}

// Derived class
class SalaryEmployee extends Employee {
    double basicSalary;
    double allowance;

    void inputSalary(double basicSalary, double allowance) {
        this.basicSalary = basicSalary;
        this.allowance = allowance;
    }

    double calculateTotalSalary() {
        return basicSalary + allowance;
    }

    void displaySalaryDetails() {
        displayEmployee();
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Allowance: " + allowance);
        System.out.println("Total Salary: " + calculateTotalSalary());
    }
}

// Main class
public class Inheritance2 {
    public static void main(String[] args) {
        SalaryEmployee emp = new SalaryEmployee();
        emp.inputEmployee(111, "Zara");
        emp.inputSalary(250000, 50000);
        emp.displaySalaryDetails();
    }
}
