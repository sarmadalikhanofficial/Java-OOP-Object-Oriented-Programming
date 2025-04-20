public class EncapsulationExample {
    //bank account
    // Private data (encapsulated)
    private double balance;

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Getter method to access balance
    public double getBalance() {
        return balance;
    }

    // Main method to test
    public static void main(String[] args) {
        EncapsulationExample account = new EncapsulationExample();
        account.deposit(1000);
        account.withdraw(200);
        System.out.println("Your current balance is: " + account.getBalance());
    }
}
