package lab9Task3.mainpkg;


import lab9Task3.Transport.Car;
import lab9Task3.Transport.Bike;
import lab9Task3.Transport.Truck;

public class Main {
    public static void main(String[] args) {
        // Create instances of Car, Bike, and Truck
        Car car = new Car("Sedan");
        Bike bike = new Bike("Sports Bike");
        Truck truck = new Truck("Heavy Duty Truck");

        // Demonstrating Drivable functionality
        System.out.println("Demonstrating Drivable functionality:");
        car.drive();
        car.stop();
        bike.drive();
        bike.stop();
        truck.drive();
        truck.stop();

        // Demonstrating Loadable functionality for Truck
        System.out.println("\nDemonstrating Loadable functionality for Truck:");
        truck.loadCargo(5000);
        truck.unloadCargo();
        truck.loadCargo(3000);
        truck.unloadCargo();
    }
}
