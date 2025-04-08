import java.util.Random;

class ForLoopGame {

    static boolean showExpectedResult = true;
    static boolean showHints = false;

    static String playGame() {
        int lastSpace = 20; // Target space to win
        int currentSpace = 0; // Starting position
        int maxRolls = 5; // Maximum dice rolls allowed
        Random random = new Random();

        for (int i = 0; i < maxRolls; i++) {
            int die = random.nextInt(6) + 1; // Generates a number between 1 and 6
            currentSpace += die;

            System.out.println("Roll " + (i + 1) + ": You rolled a " + die + ". Now on space " + currentSpace);

            if (currentSpace == lastSpace) {
                return String.format("You're on space %d. Congrats, you win!", currentSpace);
            } else if (currentSpace > lastSpace) {
                return String.format("You've exceeded %d spaces. Sorry, you lose!", lastSpace);
            }
        }

        return String.format("You're on space %d. Sorry, you lose!", currentSpace);
    }

    public static void main(String[] args) {
        // Run the game and print the result
        String result = playGame();
        System.out.println(result);
    }
}
