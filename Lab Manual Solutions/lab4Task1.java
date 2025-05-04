// PAYMENT PROCESSOR CLASS WITH METHOD OVERLOADING
class PaymentProcessor {

    // Method with no parameters
    void processPayment() {
        System.out.println("Processing default payment.");
    }

    // Method with one integer parameter
    void processPayment(int amount) {
        System.out.println("Processing payment of amount " + amount + ".");
    }

    // Method with two parameters: int and String
    void processPayment(int amount, String customerName) {
        System.out.println("Processing payment of " + amount + " for " + customerName + ".");
    }
}

// MAIN CLASS
public class lab4Task1 {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // Calling each overloaded method
        processor.processPayment();                          // No parameter
        processor.processPayment(5000);                      // One int parameter
        processor.processPayment(7500, "Sarmad Ali");          // Two parameters: int and String
    }
}
