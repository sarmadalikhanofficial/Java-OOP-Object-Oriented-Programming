//Mixing Instance and Static Methods
class MyClass {
    // Instance fields
    int instanceField = 10;

    // Static field
    static int staticField = 20;

    // Instance method
    public void instanceMethod() {
        System.out.println("This is an instance method.");
        System.out.println("Accessing instance field: " + instanceField);
        staticMethod();  // Instance method can call static method directly
    }

    // Static method
    public static void staticMethod() {
        System.out.println("This is a static method.");
        System.out.println("Accessing static field: " + staticField);
    }
}

public class MixingInstanceandStaticMethods {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.instanceMethod();  // Calling the instance method, which in turn calls static method
    }
}
