import java.util.Random;

public class lab5Task2 {

    public static void main(String[] args) {
        int[][] stock = new int[5][4]; // 5 products, 4 branches
        Random rand = new Random();

        // Initializing the 2D array with random stock levels (0–100)
        for (int i = 0; i < stock.length; i++) {
            for (int j = 0; j < stock[i].length; j++) {
                stock[i][j] = rand.nextInt(101); // Random number between 0 and 100
            }
        }

        // Display stock levels and calculate total stock per product
        int maxStock = 0;
        int productWithMaxStock = 0;

        System.out.println("Stock Levels:");
        for (int i = 0; i < stock.length; i++) {
            int productTotal = 0;
            System.out.print("Product " + (i + 1) + ": ");
            for (int j = 0; j < stock[i].length; j++) {
                System.out.print("Branch " + (j + 1) + "=" + stock[i][j] + "  ");
                productTotal += stock[i][j];
            }
            System.out.println(" | Total: " + productTotal);

            if (productTotal > maxStock) {
                maxStock = productTotal;
                productWithMaxStock = i;
            }
        }

        System.out.println("\nProduct with the highest stock: Product " + (productWithMaxStock + 1) + " (Total Stock: " + maxStock + ")");
    }
}
    