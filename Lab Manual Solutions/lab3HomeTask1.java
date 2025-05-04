class box {
    double width;
    double height;
    double depth;

    // Default constructor
    box() {
        width = 1;
        height = 1;
        depth = 1;
    }

    // Parameterized constructor
    box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // Method to calculate volume
    double volume() {
        return width * height * depth;
    }

    // Method to calculate surface area
    double getSurfaceArea() {
        return 2 * (width * height + width * depth + height * depth);
    }

    // Method to compare with another box
    boolean isEqual(box otherBox) {
        return this.width == otherBox.width &&
               this.height == otherBox.height &&
               this.depth == otherBox.depth;
    }
}

// Test class
public class lab3HomeTask1 {
    public static void main(String[] args) {
        // Using default constructor
        box box1 = new box();

        // Using parameterized constructor
        box box2 = new box(2, 3, 4);
        box box3 = new box(2, 3, 4);
        box box4 = new box(5, 5, 5);

        // Testing volume
        System.out.println("Volume of box1: " + box1.volume());
        System.out.println("Volume of box2: " + box2.volume());

        // Testing surface area
        System.out.println("Surface area of box2: " + box2.getSurfaceArea());
        System.out.println("Surface area of box4: " + box4.getSurfaceArea());

        // Testing isEqual method
        System.out.println("box2 is equal to box3: " + box2.isEqual(box3));
        System.out.println("box1 is equal to box4: " + box1.isEqual(box4));
    }
}
