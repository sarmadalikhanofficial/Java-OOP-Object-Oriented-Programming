package lab8HomeTask1.mainpkg;

import lab8HomeTask1.shapes.Circle;           // Import Circle class from shapes package
import lab8HomeTask1.operations.Calculator;   // Import Calculator class from operations package

public class Main {
    public static void main(String[] args) {
        // Create an instance of Circle from the shapes package
        Circle circle = new Circle();
        double radius = 5.0;
        double area = circle.calculateArea(radius);
        System.out.println("Area of the circle with radius " + radius + ": " + area);

        // Create an instance of Calculator from the operations package
        Calculator calculator = new Calculator();
        int a = 10, b = 5;
        int sum = calculator.add(a, b);
        int difference = calculator.subtract(a, b);

        System.out.println("Addition of " + a + " and " + b + ": " + sum);
        System.out.println("Subtraction of " + a + " and " + b + ": " + difference);
    }
}
