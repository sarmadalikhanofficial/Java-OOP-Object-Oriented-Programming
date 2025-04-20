// BankAccount class using encapsulation
public class BankAccount {
    // Private variable (can't be accessed directly from outside the class)
    private double balance;

    // Public method to deposit money (only if amount > 0)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Public method to withdraw money (only if amount <= balance)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Getter method to check current balance
    public double getBalance() {
        return balance;
    }
}

// Main class to test BankAccount
class EncapsulationExample {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();

        myAccount.deposit(1000);   // Deposit 1000
        myAccount.withdraw(300);   // Withdraw 300

        System.out.println("Current Balance: " + myAccount.getBalance()); // Output: 700.0
    }
}
