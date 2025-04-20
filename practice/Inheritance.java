// Parent class
class Vehicle {
    public void move() {
        System.out.println("The vehicle is moving");
    }
}

// Child class (inherits from Vehicle)
class Car extends Vehicle {
    @Override
    public void move() {
        System.out.println("The car is driving");
    }
}

// Main class with main method
public class Inheritance {
    public static void main(String[] args) {
        // Creating object of Vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.move(); // Output: The vehicle is moving

        // Creating object of Car
        Car car = new Car();
        car.move(); // Output: The car is driving
    }
}



// Why do we write @Override?
// To catch mistakes
// If you accidentally:

// spell the method wrong

// use wrong parameters

// or the method doesn't exist in the parent...

// Java will give an error. So you don’t silently mess up.