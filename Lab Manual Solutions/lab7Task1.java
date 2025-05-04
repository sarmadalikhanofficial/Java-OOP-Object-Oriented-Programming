// Abstract class definition
abstract class Account {
    protected String id;
    protected double balance;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getID() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public abstract boolean withdraw(double amount);
    public abstract void deposit(double amount);
}

// Subclass implementation: SavingsAccount
class SavingsAccount extends Account {

    public SavingsAccount(String id, double initialDeposit) {
        super(id, initialDeposit);
        if (initialDeposit < 10) {
            throw new IllegalArgumentException("Initial deposit must be at least $10.");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public boolean withdraw(double amount) {
        final double fee = 2.0;
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }

        if (balance - amount - fee >= 10) {
            balance -= amount + fee;
            return true;
        } else {
            System.out.println("Insufficient funds. Minimum balance of $10 must be maintained after withdrawal.");
            return false;
        }
    }
}

// Testing class
public class lab7Task1 {
    public static void main(String[] args) {
        // Create SavingsAccount with initial deposit
        SavingsAccount account = new SavingsAccount("ACC001", 50.0);

        System.out.println("Initial balance: $" + account.getBalance());

        // Deposit money
        account.deposit(25.0);
        System.out.println("Balance after deposit of $25: $" + account.getBalance());

        // Successful withdrawal
        boolean success1 = account.withdraw(30.0);
        System.out.println("Withdrawal of $30 successful? " + success1);
        System.out.println("Balance after withdrawal: $" + account.getBalance());

        // Failed withdrawal
        boolean success2 = account.withdraw(40.0);
        System.out.println("Withdrawal of $40 successful? " + success2);
        System.out.println("Balance after attempted withdrawal: $" + account.getBalance());
    }
}
