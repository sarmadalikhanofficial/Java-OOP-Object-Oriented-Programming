class Vehicle {
    String name;
    String engineType;

    public void move() {
        System.out.println("Vehicle is moving...");
    }

    public void tellName() {
        System.out.println("This vehicle is: " + name);
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    public void openDoors() {
        System.out.println(numberOfDoors + " doors are opened.");
    }
}

class Bike extends Vehicle {
    boolean hasSideCar;

    public void doWheelie() {
        System.out.println("Bike is doing a wheelie!");
    }
}

public class Extend {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.name = "Toyota Camry";
        myCar.engineType = "Petrol";
        myCar.numberOfDoors = 4;

        Bike myBike = new Bike();
        myBike.name = "Harley-Davidson Sportster";
        myBike.engineType = "Petrol";
        myBike.hasSideCar = false;

        myCar.move();
        myCar.tellName();
        myCar.openDoors();

        myBike.move();
        myBike.tellName();
        myBike.doWheelie();
    }
}