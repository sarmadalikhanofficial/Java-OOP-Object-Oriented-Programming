// Base class: Person
class Person {
    String name;
    String address;
    String phoneNumber;
    String email;

    // Constructor
    Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Overridden toString
    public String toString() {
        return "Person [Name: " + name + ", Address: " + address +
               ", Phone: " + phoneNumber + ", Email: " + email + "]";
    }
}

// Employee class extending Person
class Employee extends Person {
    double salary;
    String dateHired;

    // Constructor
    Employee(String name, String address, String phoneNumber, String email, double salary, String dateHired) {
        super(name, address, phoneNumber, email);
        this.salary = salary;
        this.dateHired = dateHired;
    }

    // Overridden toString
    public String toString() {
        return "Employee [Name: " + name + ", Salary: $" + salary +
               ", Date Hired: " + dateHired + "]";
    }
}

// Faculty class extending Employee
class Faculty extends Employee {
    String officeHours;
    String rank;

    // Constructor
    Faculty(String name, String address, String phoneNumber, String email,
            double salary, String dateHired, String officeHours, String rank) {
        super(name, address, phoneNumber, email, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    // Overridden toString
    public String toString() {
        return "Faculty [Name: " + name + ", Rank: " + rank + ", Office Hours: " +
               officeHours + ", Salary: $" + salary + ", Date Hired: " + dateHired + "]";
    }
}

// Main class
public class lab6Task2 {
    public static void main(String[] args) {
        Person person = new Person("Ali", "Karachi", "0345-1234567", "ali@example.com");
        Employee employee = new Employee("Ahmed", "Lahore", "0312-9876543", "ahmed@company.com", 75000, "01-05-2020");
        Faculty faculty = new Faculty("Dr. Sana", "Islamabad", "0301-1122334", "sana@uni.edu", 120000, "15-08-2015", "9am - 12pm", "Associate Professor");

        // Print all details
        System.out.println(person.toString());
        System.out.println(employee.toString());
        System.out.println(faculty.toString());
    }
}
