public class lab5Task3 {

    public static void main(String[] args) {
        String[] customers = {"John", "Alice", "Bob", "john", "ALICE", "Eve"};

        System.out.println("Duplicate customer names (case-insensitive):");
        boolean foundDuplicate = false;

        for (int i = 0; i < customers.length; i++) {
            for (int j = i + 1; j < customers.length; j++) {
                if (customers[i].equalsIgnoreCase(customers[j])) {
                    System.out.println("- " + customers[i]);
                    foundDuplicate = true;
                    break; // Optional: stop after first duplicate match for this name
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No duplicates found.");
        }
    }
}
