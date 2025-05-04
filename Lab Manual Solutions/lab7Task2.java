// Final class definition — cannot be inherited
final class ShippingBox {
    private double width;
    private double height;
    private double depth;

    // Constructor to initialize dimensions
    public ShippingBox(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // Method to calculate volume
    public double calculateVolume() {
        return width * height * depth;
    }
}

// This class will cause a compile-time error because ShippingBox is final
/*
class CustomBox extends ShippingBox {
    public CustomBox(double w, double h, double d) {
        super(w, h, d);
    }
}
*/


public class lab7Task2 {
    public static void main(String[] args) {
        // Create instance of ShippingBox
        ShippingBox box = new ShippingBox(2.5, 3.0, 4.0);

        // Calculate and display volume
        double volume = box.calculateVolume();
        System.out.println("Volume of the shipping box: " + volume + " cubic units");
    }
}
