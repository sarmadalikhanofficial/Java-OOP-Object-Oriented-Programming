class car {
    // Attributes
    String make;
    String model;
    int year;
    double price;

    // Constructor to initialize car attributes
    car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Method to display car details
    void displayCarDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
        System.out.println("---------------------------");
    }

    // Method to apply discount to the price
    void applyDiscount(double percentage) {
        double discount = (percentage / 100) * price;
        price -= discount;
        System.out.println("Discount of " + percentage + "% applied. New price: $" + price);
    }

    // Method to check if the car is a classic
    boolean isClassic() {
        int currentYear = java.time.Year.now().getValue();
        return (currentYear - year) > 20;
    }
}

// Main class
public class lab3Task3 {
    public static void main(String[] args) {
        // Create car objects
        car car1 = new car("Toyota", "Corolla", 2002, 1500000);
        car car2 = new car("Honda", "Civic", 2020, 3200000);

        // Display car details
        car1.displayCarDetails();
        car2.displayCarDetails();

        // Apply discount
        car2.applyDiscount(10);

        // Check if cars are classic
        System.out.println(car1.make + " " + car1.model + " is classic: " + car1.isClassic());
        System.out.println(car2.make + " " + car2.model + " is classic: " + car2.isClassic());
    }
}
