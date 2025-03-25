public class SwitchExpression2 {

    public static void main(String[] args) {

        float firstNumber = 2;
        float secondNumber = 8;
        String operation = "-"; // Change this to "-" to test subtraction

        float result = switch (operation) {
            case "+" -> {
                System.out.println("Adding...");
                yield firstNumber + secondNumber;
            }
            case "-" -> {
                System.out.println("Subtracting...");
                yield firstNumber - secondNumber;
            }
            default -> 0; // Default case if operation is not "+" or "-"
        };

        System.out.println("Result: " + result);
    }
}