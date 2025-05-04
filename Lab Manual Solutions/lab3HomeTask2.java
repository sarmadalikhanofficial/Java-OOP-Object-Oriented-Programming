class rectangle {
    double length;
    double width;

    // Default constructor
    rectangle() {
        length = 0;
        width = 0;
    }

    // Parameterized constructor
    rectangle(double l, double w) {
        if (l < 0 || w < 0) {
            System.out.println("Invalid dimensions. Length and width must be non-negative.");
            length = 0;
            width = 0;
        } else {
            length = l;
            width = w;
        }
    }

    // Method to calculate area
    double calculateArea() {
        return length * width;
    }

    // Method to calculate perimeter
    double calculatePerimeter() {
        return 2 * (length + width);
    }

    // Method to check if it's a square
    boolean isSquare() {
        return length == width && length != 0;
    }

    // Method to display rectangle info
    void displayRectangleInfo() {
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Is Square: " + isSquare());
        System.out.println("--------------------------");
    }
}

// Test class
public class lab3HomeTask2 {
    public static void main(String[] args) {
        // Using default constructor
        rectangle rect1 = new rectangle();

        // Using parameterized constructor (valid input)
        rectangle rect2 = new rectangle(4, 5);
        rectangle rect3 = new rectangle(3, 3);

        // Using parameterized constructor (invalid input)
        rectangle rect4 = new rectangle(-2, 4);

        // Display info for all rectangles
        System.out.println("Rectangle 1:");
        rect1.displayRectangleInfo();

        System.out.println("Rectangle 2:");
        rect2.displayRectangleInfo();

        System.out.println("Rectangle 3:");
        rect3.displayRectangleInfo();

        System.out.println("Rectangle 4:");
        rect4.displayRectangleInfo();
    }
}
