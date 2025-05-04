public class lab5HomeTask2 {

    public static void main(String[] args) {
        int[] stock = {30, 10, 20, 10, 50, 60, 20}; // sample stock levels
        int result = findSecondSmallest(stock);

        if (result == Integer.MAX_VALUE) {
            System.out.println("Cannot find second smallest: not enough distinct stock values.");
        } else {
            System.out.println("Second lowest stock quantity: " + result);
        }
    }

    public static int findSecondSmallest(int[] stock) {
        if (stock.length < 2) return Integer.MAX_VALUE;

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int value : stock) {
            if (value < smallest) {
                secondSmallest = smallest;
                smallest = value;
            } else if (value < secondSmallest && value != smallest) {
                secondSmallest = value;
            }
        }

        // Check if secondSmallest was ever updated
        if (secondSmallest == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return secondSmallest;
    }
}
