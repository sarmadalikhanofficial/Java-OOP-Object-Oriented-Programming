// Base class
class BankAccount {
    String accountNumber;
    double balance;
    String ownerName;

    // Constructor
    BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // Deposit method
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    // Apply interest (default 2%)
    void applyInterest() {
        double interest = balance * 0.02;
        balance += interest;
        System.out.println("Interest applied: " + interest + ". New Balance: " + balance);
    }

    void printDetails() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: " + balance);
        System.out.println("-----------------------------");
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private final double interestRate = 0.05; // 5% interest

    SavingsAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Savings Interest applied: " + interest + ". New Balance: " + balance);
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    private final double overdraftLimit = 500.0;

    CheckingAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println(amount + " withdrawn from Checking. New Balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded. Withdrawal failed.");
        }
    }

    @Override
    void applyInterest() {
        System.out.println("No interest applied on Checking Account.");
    }
}

// Subclass: BusinessAccount
class BusinessAccount extends BankAccount {
    private final double interestRate = 0.03; // 3% interest
    private final double withdrawalLimit = 10000.0;

    BusinessAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance && amount <= withdrawalLimit) {
            balance -= amount;
            System.out.println(amount + " withdrawn from Business Account. New Balance: " + balance);
        } else {
            System.out.println("Exceeded withdrawal limit or insufficient funds.");
        }
    }

    @Override
    void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Business Interest applied: " + interest + ". New Balance: " + balance);
    }
}

// Main class
public class lab6Scenario3 {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", "Ali", 5000);
        CheckingAccount checking = new CheckingAccount("CA456", "Zara", 1000);
        BusinessAccount business = new BusinessAccount("BA789", "Ahsan", 20000);

        savings.printDetails();
        savings.deposit(1000);
        savings.withdraw(2000);
        savings.applyInterest();

        System.out.println();

        checking.printDetails();
        checking.deposit(500);
        checking.withdraw(1300); // should allow with overdraft
        checking.applyInterest();

        System.out.println();

        business.printDetails();
        business.withdraw(9500);
        business.applyInterest();
    }
}
