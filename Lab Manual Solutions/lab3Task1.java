// Item class to represent an item in the shopping cart
class Item {
    // Attributes
    String name;
    double price;
    int quantity;

    // Constructor
    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate total price
    double getTotalPrice() {
        return price * quantity;
    }

    // Method to display item details
    void displayItemDetails() {
        System.out.println("Item Name: " + name);
        System.out.println("Price per unit: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: $" + getTotalPrice());
        System.out.println("-----------------------------");
    }

    // Method to update quantity
    void updateQuantity(int additionalQuantity) {
        quantity += additionalQuantity;
        System.out.println(additionalQuantity + " more " + name + "(s) added to the cart.");
    }
}

// Main class
public class lab3Task1 {
    public static void main(String[] args) {
        // Creating item objects
        Item item1 = new Item("Laptop", 750.0, 1);
        Item item2 = new Item("Headphones", 50.0, 2);

        // Display initial item details
        item1.displayItemDetails();
        item2.displayItemDetails();

        // Update quantities
        item1.updateQuantity(1);  // Adding another Laptop
        item2.updateQuantity(3);  // Adding 3 more Headphones

        // Display updated details
        System.out.println("After updating quantities:\n");
        item1.displayItemDetails();
        item2.displayItemDetails();
    }
}
