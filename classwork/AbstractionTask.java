// Abstract class
abstract class Shape {
    int edges; // common variable for number of edges

    // Abstract method (must be implemented by subclasses)
    public abstract void printEdges();
}

// Subclass 1: Square
class Square extends Shape {
    Square() {
        edges = 4;
    }

    @Override
    public void printEdges() {
        System.out.println("Square has " + edges + " edges.");
    }
}

// Subclass 2: Triangle
class Triangle extends Shape {
    Triangle() {
        edges = 3;
    }

    @Override
    public void printEdges() {
        System.out.println("Triangle has " + edges + " edges.");
    }
}

// Subclass 3: Pentagon
class Pentagon extends Shape {
    Pentagon() {
        edges = 5;
    }

    @Override
    public void printEdges() {
        System.out.println("Pentagon has " + edges + " edges.");
    }
}

// Main class
public class AbstractionTask {
    public static void main(String[] args) {
        // Create objects
        Shape s1 = new Square();
        Shape s2 = new Triangle();
        Shape s3 = new Pentagon();

        // Call method for all shapes
        s1.printEdges();
        s2.printEdges();
        s3.printEdges();
    }
}
