// Base class: Box
class Box {
    double width, height, depth;

    // Constructor
    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // Method to calculate volume
    double getVolume() {
        return width * height * depth;
    }
}

// Subclass: BoxWeight extends Box
class BoxWeight extends Box {
    double weight;

    // Constructor
    BoxWeight(double width, double height, double depth, double weight) {
        super(width, height, depth);
        this.weight = weight;
    }
}

// Subclass: Shipment extends BoxWeight
class Shipment extends BoxWeight {
    double cost;

    // Constructor
    Shipment(double width, double height, double depth, double weight, double cost) {
        super(width, height, depth, weight);
        this.cost = cost;
    }

    // Method to display shipment details
    void displayDetails() {
        System.out.println("Volume: " + getVolume() + " cubic units");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Shipping Cost: $" + cost);
        System.out.println("----------------------------");
    }
}

// Main class
public class lab6Task3 {
    public static void main(String[] args) {
        // Creating shipment objects
        Shipment s1 = new Shipment(2.0, 3.0, 4.0, 5.0, 25.0);
        Shipment s2 = new Shipment(1.5, 2.5, 3.5, 4.0, 18.5);

        // Display shipment details
        System.out.println("Shipment 1:");
        s1.displayDetails();

        System.out.println("Shipment 2:");
        s2.displayDetails();
    }
}
