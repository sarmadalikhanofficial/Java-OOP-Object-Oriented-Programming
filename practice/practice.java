// Abstract class
abstract class Animal {
    // Abstract method (no body — must be overridden)
    public abstract void makeSound();

    // Normal method (has body)
    public void sleep() {
        System.out.println("The animal is sleeping");
    }
}

// Subclass of Animal
class Dog extends Animal {
    // Implementing the abstract method
    @Override
    public void makeSound() {
        System.out.println("The dog barks");
    }
}

// Main class with main method
public class Abstraction {
    public static void main(String[] args) {
        // We can't create Animal directly because it's abstract
        // Animal a = new Animal(); ❌ Error

        // Create an object of Dog, but refer to it as an Animal (Polymorphism)
        Animal myDog = new Dog();
        myDog.makeSound();  // Output: The dog barks
        myDog.sleep();      // Output: The animal is sleeping
    }
}