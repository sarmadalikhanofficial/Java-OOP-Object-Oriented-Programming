// Base class
class Vehicle {
    String make;
    String model;
    int year;

    // Constructor
    Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to calculate insurance (default base cost)
    double calculateInsurance() {
        return 1000.0; // base cost
    }

    // Method to display details
    void displayInsuranceDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Insurance Cost: $" + calculateInsurance());
        System.out.println("-----------------------------");
    }
}

// Car class
class Car extends Vehicle {
    double carValue;

    Car(String make, String model, int year, double carValue) {
        super(make, model, year);
        this.carValue = carValue;
    }

    @Override
    double calculateInsurance() {
        return 1000.0 + (0.05 * carValue); // 5% of car value added to base
    }
}

// Motorcycle class
class Motorcycle extends Vehicle {
    boolean isHighPerformance;

    Motorcycle(String make, String model, int year, boolean isHighPerformance) {
        super(make, model, year);
        this.isHighPerformance = isHighPerformance;
    }

    @Override
    double calculateInsurance() {
        return isHighPerformance ? 1200.0 : 600.0; // higher for high-performance
    }
}

// Truck class
class Truck extends Vehicle {
    double weight; // in tons
    double cargoCapacity; // in tons

    Truck(String make, String model, int year, double weight, double cargoCapacity) {
        super(make, model, year);
        this.weight = weight;
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    double calculateInsurance() {
        return 1500.0 + (weight * 50) + (cargoCapacity * 75); // higher base + weight/cargo fees
    }
}

// Main class
public class lab6Scenario2 {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2020, 25000);
        Motorcycle bike = new Motorcycle("Yamaha", "R1", 2022, true);
        Truck truck = new Truck("Volvo", "FH16", 2019, 8.5, 12);

        car.displayInsuranceDetails();
        bike.displayInsuranceDetails();
        truck.displayInsuranceDetails();
    }
}
