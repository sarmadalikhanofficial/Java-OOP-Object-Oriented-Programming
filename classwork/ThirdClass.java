// This is the parent class (superclass)
class lab1 {  
	
    // A method named 'task' inside the lab1 class
    public void task() {  
        
        // Declaring and initializing an integer variable 'myNum' with a value of 10
        int myNum = 111;  

        // Conditional statement to check if 'myNum' is positive, negative, or zero
        if (myNum > 0) {  
            // If 'myNum' is greater than 0, this message will be printed
            System.out.println("The value is a positive number.");  
        } else if (myNum < 0) {  
            // If 'myNum' is less than 0, this message will be printed
            System.out.println("The value is a negative number.");  
        } else {  
            // If 'myNum' is neither greater than nor less than 0, it must be 0
            System.out.println("The value is 0.");  
        }
    }
}

// This is the child class (subclass) which inherits from 'lab1' using 'extends' keyword
class lab2 extends lab1 {  
    // Since lab2 does not define any methods, it automatically inherits 'task()' from lab1
}

// This is the main class that contains the main method (entry point of the Java program)
public class ThirdClass {  

    // The main method where execution starts
    public static void main(String[] args) {  
        
        // Creating an object 'obj1' of the child class 'lab2'
        lab2 obj1 = new lab2();  

        // Calling the inherited method 'task()' using the object of 'lab2'
        obj1.task();  
    }
}
