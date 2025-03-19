// This class represents a base (parent) class with a single attribute.
class Lab1 {
    String brand = "Ford";  // A string variable 'brand' initialized with "Ford"
}

// This class (Lab2) extends Lab1, meaning it inherits all properties of Lab1.
class Lab2 extends Lab1 { 
    String modelname = "Mustang";  // A string variable 'modelname' initialized with "Mustang"
}

// This is the main class that contains the entry point (main method) of the Java program.
public class FourthClass {  // The filename should be FourthClass.java since it's the public class.
    
    // The main method is the starting point of any Java program.
    public static void main(String[] args) {
        
        // Creating an object of class Lab2. 
        // Since Lab2 extends Lab1, it inherits the 'brand' variable from Lab1.
        Lab2 obj1 = new Lab2();  

        // Printing the values of 'brand' (from Lab1) and 'modelname' (from Lab2).
        System.out.println(obj1.brand + " " + obj1.modelname);
        // Expected Output: Ford Mustang
    }
}
