// HOME TASK #1 – OVERLOADING WITH DIFFERENT DATA TYPES

// COMPLEX CLASS
class Complex {
    private double real;
    private double imaginary;

    // Constructor
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Getters
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    // Setters
    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    // toString method to display complex number in "a + bi" format
    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

// OVERLOAD DEMO CLASS
class OverloadDemo {
    
    // No parameter
    public void test() {
        System.out.println("No parameters provided.");
    }

    // Single int
    public void test(int a) {
        System.out.println("Single int parameter: " + a);
    }

    // Single double
    public void test(double a) {
        System.out.println("Single double parameter: " + a);
    }

    // Two int parameters
    public void test(int a, int b) {
        System.out.println("Two int parameters: " + a + " and " + b);
    }

    // Two Complex number parameters
    public void test(Complex c1, Complex c2) {
        double sumReal = c1.getReal() + c2.getReal();
        double sumImaginary = c1.getImaginary() + c2.getImaginary();
        Complex sum = new Complex(sumReal, sumImaginary);
        System.out.println("Sum of complex numbers: " + sum.toString());
    }
}

// MAIN CLASS
public class lab4HomeTask1 {
    public static void main(String[] args) {
        OverloadDemo demo = new OverloadDemo();

        // Demonstrate method overloading
        demo.test();
        demo.test(10);
        demo.test(3.14);
        demo.test(5, 7);

        // Complex number operations
        Complex c1 = new Complex(2.5, 3.5);
        Complex c2 = new Complex(1.5, 4.0);
        demo.test(c1, c2);
    }
}
