// File: BankAccount.java
public class BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    // Method for deposit
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative.");
        }
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    // Method for withdrawal
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
        System.out.println("Withdrew: $" + amount);
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }
}

// Custom exception for insufficient funds
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}


public class lab9Task1 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance $1000

        // Simulating user interactions
        try {
            account.deposit(500); // Deposit $500
            System.out.println("Balance after deposit: $" + account.getBalance());

            account.withdraw(200); // Withdraw $200
            System.out.println("Balance after withdrawal: $" + account.getBalance());

            account.withdraw(2000); // Attempt to withdraw more than available (should throw exception)
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
