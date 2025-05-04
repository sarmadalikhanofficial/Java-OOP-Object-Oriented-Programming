// Base Class: Person
abstract class Person {
    protected String name;
    protected int age;
    protected String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public abstract void displayInfo();
}

// Subclass: Patient
class Patient extends Person {
    private String patientId;
    private String medicalHistory;

    public Patient(String name, int age, String gender, String patientId, String medicalHistory) {
        super(name, age, gender);
        this.patientId = patientId;
        this.medicalHistory = medicalHistory;
    }

    public void displayInfo() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", History: " + medicalHistory);
    }
}

// Subclass: Doctor
class Doctor extends Person {
    private String specialization;
    private String doctorId;

    public Doctor(String name, int age, String gender, String doctorId, String specialization) {
        super(name, age, gender);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("Doctor ID: " + doctorId + ", Name: " + name + ", Specialization: " + specialization);
    }
}

// Subclass: Staff
class Staff extends Person {
    private String role;

    public Staff(String name, int age, String gender, String role) {
        super(name, age, gender);
        this.role = role;
    }

    public void displayInfo() {
        System.out.println("Staff Name: " + name + ", Role: " + role);
    }
}

// Class: Ward
class Ward {
    private String wardId;
    private int capacity;
    private int occupied;

    public Ward(String wardId, int capacity) {
        this.wardId = wardId;
        this.capacity = capacity;
        this.occupied = 0;
    }

    public boolean assignPatient() {
        if (occupied < capacity) {
            occupied++;
            return true;
        }
        return false;
    }

    public void displayStatus() {
        System.out.println("Ward ID: " + wardId + ", Capacity: " + capacity + ", Occupied: " + occupied);
    }
}

// Class: Hospital
class Hospital {
    private String hospitalName;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void generateReport() {
        System.out.println("Generating report for: " + hospitalName);
        // This would include looping over wards, patients, doctors, etc. in a real app.
    }
}

// Main class to run the program
public class OEL {
    public static void main(String[] args) {
        Patient p1 = new Patient("Alice", 30, "Female", "P001", "Diabetes");
        Doctor d1 = new Doctor("Dr. Smith", 45, "Male", "D001", "Cardiology");
        Staff s1 = new Staff("John", 38, "Male", "Nurse");

        Ward ward1 = new Ward("W101", 10);
        Hospital hospital = new Hospital("City Hospital");

        p1.displayInfo();
        d1.displayInfo();
        s1.displayInfo();

        if (ward1.assignPatient()) {
            System.out.println("Patient assigned to ward.");
        } else {
            System.out.println("Ward full!");
        }

        ward1.displayStatus();
        hospital.generateReport();
    }
}
