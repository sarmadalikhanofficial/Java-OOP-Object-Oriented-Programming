class Person {
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String email;

    public Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

abstract class Employee extends Person {
    protected double salary;
    protected String dateHired;

    public Employee(String name, String address, String phoneNumber, String email, double salary, String dateHired) {
        super(name, address, phoneNumber, email);
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public abstract String getDetails();
}

class Faculty extends Employee {
    private String department;
    private String designation;

    public Faculty(String name, String address, String phoneNumber, String email,
                   double salary, String dateHired, String department, String designation) {
        super(name, address, phoneNumber, email, salary, dateHired);
        this.department = department;
        this.designation = designation;
    }

    @Override
    public String getDetails() {
        return "Faculty Member:\n" +
               "Name: " + name + "\nDepartment: " + department + "\nDesignation: " + designation +
               "\nSalary: $" + salary + "\nDate Hired: " + dateHired;
    }
}

class Staff extends Employee {
    private String role;

    public Staff(String name, String address, String phoneNumber, String email,
                 double salary, String dateHired, String role) {
        super(name, address, phoneNumber, email, salary, dateHired);
        this.role = role;
    }

    @Override
    public String getDetails() {
        return "Staff Member:\n" +
               "Name: " + name + "\nRole: " + role +
               "\nSalary: $" + salary + "\nDate Hired: " + dateHired;
    }
}

public class lab7Task3 {
    public static void main(String[] args) {
        Faculty faculty = new Faculty(
            "Dr. Sara Ahmed", "123 Uni Street", "021-1234567", "sara@uni.edu",
            85000.0, "2020-09-15", "Computer Science", "Professor"
        );

        Staff staff = new Staff(
            "John Doe", "456 Admin Ave", "021-7654321", "john@uni.edu",
            50000.0, "2018-03-10", "Registrar"
        );

        // Demonstrating polymorphism
        System.out.println(faculty.getDetails());
        System.out.println("\n-----------------------------\n");
        System.out.println(staff.getDetails());
    }
}
