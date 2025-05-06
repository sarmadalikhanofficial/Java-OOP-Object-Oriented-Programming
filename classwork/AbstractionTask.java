// abstract class
abstract class Shape {
    // abstract method
    abstract public void edges();
}

// child class implementing the abstract method
class Triangle extends Shape {
    
    public void edges() {
        int corner = 3;
        System.out.println("triangle has " + corner + " corners");
    }
}

// another child class
class Circle extends Shape {
    @Override
    public void edges() {
        int corner = 0;
        System.out.println("circle has " + corner + " corners");
    }
}


// another child class
class Pentagon extends Shape {
    @Override
    public void edges() {
        int corner = 5;
        System.out.println("pentagon has " + corner + " corners");
    }
}

// another child class
class Square extends Shape {
    @Override
    public void edges() {
        int corner = 4;
        System.out.println("square has " + corner + " corners");
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
        circle.edges(); 

        
        // object of pentagon
        Shape pentagon = new Pentagon();
        pentagon.edges(); 
        
        // object of square
        Shape square = new Square();
        square.edges(); 
    }
}
