abstract class Shape {
    // Abstract method to calculate area
    public abstract double calculateArea();

    // Non-abstract method to display the calculated area
    public void displayArea(double area) {
        System.out.println("Area: " + area);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;  // Area of circle: π * radius^2
    }
}

class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth;  // Area of rectangle: length * breadth
    }
}

public class lab7HomeTask1 {
    public static void main(String[] args) {
        // Create a Circle object with radius 5.0
        Circle circle = new Circle(5.0);
        double circleArea = circle.calculateArea();
        circle.displayArea(circleArea);  // Display the area of the circle

        // Create a Rectangle object with length 4.0 and breadth 6.0
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        double rectangleArea = rectangle.calculateArea();
        rectangle.displayArea(rectangleArea);  // Display the area of the rectangle
    }
}
