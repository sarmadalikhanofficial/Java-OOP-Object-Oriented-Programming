// File: lab9Task2.java
import java.util.Scanner;  // Import statement should be at the top

// PaymentMethod.java
public interface PaymentMethod {
    void processPayment(double amount) throws InvalidCardException, InsufficientFundsException, PaymentNetworkException;
}

// InvalidCardException.java
public class InvalidCardException extends Exception {
    public InvalidCardException(String message) {
        super(message);
    }
}

// InsufficientFundsException.java
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// PaymentNetworkException.java
public class PaymentNetworkException extends Exception {
    public PaymentNetworkException(String message) {
        super(message);
    }
}

// CreditCard.java
public class CreditCard implements PaymentMethod {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) throws InvalidCardException {
        if (!isValidCard()) {
            throw new InvalidCardException("Invalid credit card number.");
        }
        System.out.println("Payment of $" + amount + " processed using Credit Card.");
    }

    private boolean isValidCard() {
        return cardNumber != null && cardNumber.length() == 16;
    }
}

// PayPal.java
public class PayPal implements PaymentMethod {
    private double balance;

    public PayPal(double balance) {
        this.balance = balance;
    }

    @Override
    public void processPayment(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds in PayPal account.");
        }
        balance -= amount;
        System.out.println("Payment of $" + amount + " processed using PayPal.");
    }
}

// BankTransfer.java
public class BankTransfer implements PaymentMethod {
    @Override
    public void processPayment(double amount) throws PaymentNetworkException {
        if (Math.random() > 0.7) {
            throw new PaymentNetworkException("Network issue during bank transfer.");
        }
        System.out.println("Payment of $" + amount + " processed using Bank Transfer.");
    }
}

// OnlinePaymentSystem.java
public class lab9Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean paymentProcessed = false;

        while (!paymentProcessed) {
            System.out.println("Choose payment method: 1. Credit Card 2. PayPal 3. Bank Transfer");
            int choice = scanner.nextInt();
            System.out.println("Enter payment amount:");
            double amount = scanner.nextDouble();

            PaymentMethod paymentMethod = null;
            switch (choice) {
                case 1:
                    System.out.println("Enter credit card number:");
                    String cardNumber = scanner.next();
                    paymentMethod = new CreditCard(cardNumber);
                    break;
                case 2:
                    System.out.println("Enter PayPal balance:");
                    double balance = scanner.nextDouble();
                    paymentMethod = new PayPal(balance);
                    break;
                case 3:
                    paymentMethod = new BankTransfer();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            try {
                paymentMethod.processPayment(amount);
                paymentProcessed = true;
            } catch (InvalidCardException | InsufficientFundsException | PaymentNetworkException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }

        scanner.close();
    }
}
