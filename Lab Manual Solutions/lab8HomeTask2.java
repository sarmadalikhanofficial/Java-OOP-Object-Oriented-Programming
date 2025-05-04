// File: lab8HomeTask2.java
public class lab8HomeTask2 {
    public static void main(String[] args) {
        // Create objects of Car and Bike
        Vehicle myCar = new Car();
        Vehicle myBike = new Bike();

        // Start and stop the engines for both vehicles
        myCar.startEngine();
        myCar.stopEngine();

        myBike.startEngine();
        myBike.stopEngine();
    }
}


// File: Vehicle.java
public interface Vehicle {
    // Method to start the engine
    void startEngine();
    
    // Method to stop the engine
    void stopEngine();
}


// File: Car.java
public class Car implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped.");
    }
}


// File: Bike.java
public class Bike implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Bike engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Bike engine stopped.");
    }
}

