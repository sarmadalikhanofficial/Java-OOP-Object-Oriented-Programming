/* 
abstract class means a class that cannot be used to create objects directly. it is only meant to be inherited by child classes.
an abstract class may contain:
abstract methods (methods without a body)
non-abstract methods (methods with a body)
variables
abstract methods are like rules or instructions that the child classes must follow and implement.
if a class has at least one abstract method, it must be declared as abstract.
you cannot create an object of an abstract class. instead, you use child classes that extend it and provide complete implementation.
*/

public class Abstraction {

    // Abstract class representing a Shape
    abstract static class Shape {
        // Abstract method to calculate area
        public abstract double calculateArea();

        // Concrete method to display information
        public void display() {
            System.out.println("This is a shape.");
        }
    }

    // Concrete class representing a Circle
    static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public void display() {
            System.out.println("This is a circle with radius " + radius);
        }
    }

    // Concrete class representing a Rectangle
    static class Rectangle extends Shape {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            return length * width;
        }

        @Override
        public void display() {
            System.out.println("This is a rectangle with length " + length + " and width " + width);
        }
    }

    public static void main(String[] args) {
        // Creating instances of Circle and Rectangle
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        // Calling methods to display information and calculate area
        circle.display();
        System.out.println("Area of the circle: " + circle.calculateArea());

        rectangle.display();
        System.out.println("Area of the rectangle: " + rectangle.calculateArea());
    }
}