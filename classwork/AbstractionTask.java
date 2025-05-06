// abstract class
abstract class Shape {
    // abstract method
    abstract public void edges();
}

// child class implementing the abstract method for Triangle
class Triangle extends Shape {
    @Override
    public void edges() {
        int corner = 3;
        System.out.println("triangle has " + corner + " corners");
    }
}

// child class implementing the abstract method for Circle
class Circle extends Shape {
    @Override
    public void edges() {
        int corner = 0;
        System.out.println("circle has " + corner + " corners");
    }
}

// child class implementing the abstract method for Pentagon
class Pentagon extends Shape {
    @Override
    public void edges() {
        int corner = 5;
        System.out.println("pentagon has " + corner + " corners");
    }
}

// child class implementing the abstract method for Square
class Square extends Shape {
    @Override
    public void edges() {
        int corner = 4;
        System.out.println("square has " + corner + " corners");
    }
}

// final child class for Hexagon (cannot be subclassed)
final class Hexagon extends Shape {
    @Override
    public void edges() {
        int corner = 6;
        System.out.println("hexagon has " + corner + " corners");
    }
}

// final child class for Heptagon (cannot be subclassed)
final class Heptagon extends Shape {
    @Override
    public void edges() {
        int corner = 7;
        System.out.println("heptagon has " + corner + " corners");
    }
}

// final child class for Octagon (cannot be subclassed)
final class Octagon extends Shape {
    @Override
    public void edges() {
        int corner = 8;
        System.out.println("octagon has " + corner + " corners");
    }
}

// main class to perform abstraction
public class AbstractionTask {
    public static void main(String[] args) {
        // object of triangle
        Shape triangle = new Triangle();
        triangle.edges(); // output: triangle has 3 corners

        // object of circle
        Shape circle = new Circle();
        circle.edges(); // output: circle has 0 corners

        // object of pentagon
        Shape pentagon = new Pentagon();
        pentagon.edges(); // output: pentagon has 5 corners

        // object of square
        Shape square = new Square();
        square.edges(); // output: square has 4 corners

        // object of hexagon
        Shape hexagon = new Hexagon();
        hexagon.edges(); // output: hexagon has 6 corners

        // object of heptagon
        Shape heptagon = new Heptagon();
        heptagon.edges(); // output: heptagon has 7 corners

        // object of octagon
        Shape octagon = new Octagon();
        octagon.edges(); // output: octagon has 8 corners
    }
}
