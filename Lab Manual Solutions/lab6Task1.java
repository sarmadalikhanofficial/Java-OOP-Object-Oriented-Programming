// Base class: Vehicle
class Vehicle {
    private String manufacturer;
    private String model;
    protected int manufacturingYear;

    // Constructor
    public Vehicle(String manufacturer, String model, int manufacturingYear) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
    }

    // Method to display vehicle details
    public String displayDetails() {
        return "Manufacturer: " + manufacturer + 
               ", Model: " + model + 
               ", Year: " + manufacturingYear;
    }
}

// Derived class: Sedan
class Sedan extends Vehicle {
    private int numberOfDoors;

    // Constructor
    public Sedan(String manufacturer, String model, int manufacturingYear, int numberOfDoors) {
        super(manufacturer, model, manufacturingYear);
        this.numberOfDoors = numberOfDoors;
    }

    // Overridden method
    @Override
    public String displayDetails() {
        return super.displayDetails() + 
               ", Doors: " + numberOfDoors;
    }
}

// Derived class: CargoTruck
class CargoTruck extends Vehicle {
    private double cargoCapacity;

    // Constructor
    public CargoTruck(String manufacturer, String model, int manufacturingYear, double cargoCapacity) {
        super(manufacturer, model, manufacturingYear);
        this.cargoCapacity = cargoCapacity;
    }

    // Overridden method
    @Override
    public String displayDetails() {
        return super.displayDetails() + 
               ", Cargo Capacity: " + cargoCapacity + " tons";
    }
}

// Test class
public class lab6Task1 {
    public static void main(String[] args) {
        Sedan sedan = new Sedan("Toyota", "Camry", 2020, 4);
        CargoTruck truck = new CargoTruck("Volvo", "FH16", 2018, 18.5);

        System.out.println(sedan.displayDetails());
        System.out.println(truck.displayDetails());
    }
}
