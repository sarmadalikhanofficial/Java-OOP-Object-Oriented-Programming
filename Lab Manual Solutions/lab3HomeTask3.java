class account {
    String accountNumber;
    String accountHolderName;
    double balance;

    // Parameterized constructor
    account(String accNumber, String accHolderName) {
        accountNumber = accNumber;
        accountHolderName = accHolderName;
        balance = 0.0;
    }

    // Deposit method
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds! Withdrawal failed.");
        }
    }

    // Get balance
    double getBalance() {
        return balance;
    }

    // Display account info
    void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("-----------------------------");
    }
}

// Test class
public class lab3HomeTask3 {
    public static void main(String[] args) {
        // Create accounts
        account acc1 = new account("123456", "Sarmad Ali");
        account acc2 = new account("654321", "Faiz Arshad");

        // Transactions for acc1
        acc1.displayAccountInfo();
        acc1.deposit(1000);
        acc1.withdraw(300);
        acc1.displayAccountInfo();

        // Transactions for acc2
        acc2.displayAccountInfo();
        acc2.deposit(500);
        acc2.withdraw(700);  // Should show insufficient funds
        acc2.displayAccountInfo();
    }
}
