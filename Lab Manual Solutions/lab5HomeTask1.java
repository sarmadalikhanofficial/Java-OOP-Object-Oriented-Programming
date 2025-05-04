public class lab5HomeTask1 {

    public static void main(String[] args) {
        int[] sales = {200, 450, 320, 450, 180, 320, 150}; // sample weekly sales
        int result = findSecondLargest(sales);

        if (result == Integer.MIN_VALUE) {
            System.out.println("Cannot find second largest: not enough distinct values.");
        } else {
            System.out.println("Second highest sales figure: " + result);
        }
    }

    public static int findSecondLargest(int[] sales) {
        if (sales.length < 2) return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int sale : sales) {
            if (sale > max) {
                secondMax = max;
                max = sale;
            } else if (sale > secondMax && sale != max) {
                secondMax = sale;
            }
        }

        // Check if secondMax was ever updated
        if (secondMax == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return secondMax;
    }
}
