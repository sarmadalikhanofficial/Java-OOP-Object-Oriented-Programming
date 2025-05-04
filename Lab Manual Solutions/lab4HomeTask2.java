import java.util.Date;

// BASE CLASS: Account
class Account {
    private int id;
    private double balance;
    private Date dateCreated;

    // Default constructor (sets default ID and balance)
    public Account() {
        this.id = 0;
        this.balance = 0.0;
        this.dateCreated = new Date();
    }

    // Parameterized constructor (sets specific ID and balance)
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter for dateCreated
    public Date getDateCreated() {
        return dateCreated;
    }

    // Method to withdraw amount from the balance
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to deposit amount to the balance
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to display account details
    public void displayAccountInfo() {
        System.out.println("Account ID: " + id);
        System.out.println("Balance: " + balance);
        System.out.println("Date Created: " + dateCreated);
    }
}

// DERIVED CLASS: CheckingAccount
class CheckingAccount extends Account {
    private boolean isOverdraftAllowed;

    // Constructor for CheckingAccount with ID, balance, and overdraft option
    public CheckingAccount(int id, double balance, boolean isOverdraftAllowed) {
        // Call the parent class constructor to set ID and balance
        super(id, balance);
        this.isOverdraftAllowed = isOverdraftAllowed;
    }

    // Getter and Setter for isOverdraftAllowed
    public boolean isOverdraftAllowed() {
        return isOverdraftAllowed;
    }

    public void setOverdraftAllowed(boolean isOverdraftAllowed) {
        this.isOverdraftAllowed = isOverdraftAllowed;
    }

    // Overriding method to display account details including overdraft status
    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();  // Call base class method
        System.out.println("Overdraft Allowed: " + (isOverdraftAllowed ? "Yes" : "No"));
    }
}

// MAIN CLASS: Test the Account and CheckingAccount
public class lab4HomeTask2 {
    public static void main(String[] args) {
        // Creating a regular Account
        Account account1 = new Account(101, 5000.0);
        account1.displayAccountInfo();

        System.out.println("\n");

        // Creating a CheckingAccount with overdraft allowed
        CheckingAccount checkingAccount1 = new CheckingAccount(102, 3000.0, true);
        checkingAccount1.displayAccountInfo();

        System.out.println("\n");

        // Creating a CheckingAccount with no overdraft
        CheckingAccount checkingAccount2 = new CheckingAccount(103, 2000.0, false);
        checkingAccount2.displayAccountInfo();
    }
}
