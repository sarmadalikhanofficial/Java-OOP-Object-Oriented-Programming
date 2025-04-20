// Parent class
class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

// Child class 1
class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

// Child class 2
class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

// Main class
public class PolymorphismExample {
    public static void main(String[] args) {
        Shape myShape;         // reference of parent class

        myShape = new Circle();  // object of Circle
        myShape.draw();          // Output: Drawing a circle

        myShape = new Square();  // object of Square
        myShape.draw();          // Output: Drawing a square
    }
}
