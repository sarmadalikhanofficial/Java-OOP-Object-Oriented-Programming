
public class InsufficientFundsException extends Exception {
    // Constructor that accepts a message
    public InsufficientFundsException(String message) {
        super(message);
    }
}


public class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal. Available balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }
}


public class lab9HomeTask1 {
    public static void main(String[] args) {
        // Create a BankAccount object with an initial balance of 500
        BankAccount account = new BankAccount(500);

        // Attempt to withdraw an amount larger than the balance
        try {
            System.out.println("Current balance: " + account.getBalance());
            account.withdraw(600);  // This will throw an InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Attempt to withdraw a valid amount
        try {
            account.withdraw(200);  // This will succeed
            System.out.println("Current balance: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
