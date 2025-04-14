// Example 1: Patient Data using Inheritance
// Scenario:
// We have a Person base class.

// Patient class inherits from Person.

package examprep;

// Base class
class Person {
    String name;
    int age;

    void inputPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Derived class
class Patient extends Person {
    String disease;
    String doctorName;

    void inputPatient(String disease, String doctorName) {
        this.disease = disease;
        this.doctorName = doctorName;
    }

    void displayPatient() {
        displayPerson();
        System.out.println("Disease: " + disease);
        System.out.println("Doctor: " + doctorName);
    }
}

// Main class
public class Inheritance {
    public static void main(String[] args) {
        Patient p1 = new Patient();
        p1.inputPerson("Ali", 21);
        p1.inputPatient("Flu", "Dr. Hamza");
        p1.displayPatient();
    }
}
