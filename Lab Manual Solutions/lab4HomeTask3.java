// Customer Class - Superclass
public class Customer {
    // Private field: balance
    private double balance;

    // Public method to get balance
    public double getBalance() {
        return balance;
    }

    // Protected method to set balance (used by subclasses or within the same package)
    protected void setBalance(double balance) {
        if (balance >= 0) { // Prevent negative balance
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    // Constructor to initialize balance
    public Customer(double balance) {
        this.balance = balance;
    }
}

// VIPCustomer Class - Subclass of Customer
public class VIPCustomer extends Customer {

    // Constructor to initialize balance for VIP customer
    public VIPCustomer(double balance) {
        super(balance); // Call superclass constructor to initialize balance
    }

    // Overriding setBalance method to allow unrestricted modification of balance for VIP customers
    @Override
    public void setBalance(double balance) {
        // No restrictions, allow any balance (including negative if necessary)
        super.setBalance(balance);  // Call superclass method to actually set the balance
    }
}

public class lab4HomeTask3 {
    public static void main(String[] args) {
        // Creating a regular Customer
        Customer customer1 = new Customer(1000.0);
        
        // Accessing public getBalance method
        System.out.println("Customer1 Balance: " + customer1.getBalance());

        // Attempting to access private balance directly (will cause a compile error)
        // System.out.println("Customer1 Balance (direct access): " + customer1.balance); // Error
        
        // Accessing protected setBalance method directly (will cause a compile error)
        // customer1.setBalance(2000.0); // Error

        // Creating a VIPCustomer
        VIPCustomer vipCustomer = new VIPCustomer(2000.0);
        
        // Accessing public getBalance method
        System.out.println("VIPCustomer Balance: " + vipCustomer.getBalance());

        // Modifying balance using overridden setBalance method for VIPCustomer
        vipCustomer.setBalance(5000.0);
        System.out.println("VIPCustomer Balance after modification: " + vipCustomer.getBalance());

        // Demonstrating failure in access control
        // Attempt to access private field and method from outside the class/package
        // System.out.println(vipCustomer.balance); // Error: Private field
    }
}
