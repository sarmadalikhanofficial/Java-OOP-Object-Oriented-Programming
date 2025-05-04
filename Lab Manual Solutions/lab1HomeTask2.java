public class HomeTask2 {
    public static void main(String[] args) {
        // 1. Variable Declarations
        int myInt = 42;
        float myFloat = 3.14f;
        double myDouble = 123.456789;
        char myChar = 'A';
        boolean myBool = true;

        // 2. Output Formatting
        System.out.println("Formatted Output:");
        System.out.printf("Integer: %5d\n", myInt);
        System.out.printf("Float: %.2f\n", myFloat);
        System.out.printf("Double: %.4f\n", myDouble);
        System.out.printf("Character: %c\n", myChar);
        System.out.printf("Boolean: %b\n", myBool);

        System.out.println("\n--- Type Conversions ---");

        // 3. Type Conversion
        // Double to int (Explicit)
        int intFromDouble = (int) myDouble;
        System.out.println("Casting double to int (123.456789 → " + intFromDouble + ") → Fractional part is lost");

        // Int to char
        char charFromInt = (char) myInt;
        System.out.println("Casting int to char (42 → '" + charFromInt + "') → Uses ASCII value");

        // Char to int
        int intFromChar = (int) myChar;
        System.out.println("Casting char to int ('A' → " + intFromChar + ") → ASCII value of 'A' is 65");

        System.out.println("\n--- String Conversion ---");

        // 4. String Conversion
        // Numeric to String
        String strFromInt = String.valueOf(myInt);
        String strFromDouble = String.valueOf(myDouble);
        System.out.println("Integer to String: " + strFromInt);
        System.out.println("Double to String: " + strFromDouble);

        // String to Numeric
        String numStr = "99";
        int parsedInt = Integer.parseInt(numStr);
        double parsedDouble = Double.parseDouble("45.67");

        System.out.println("Parsed Integer from \"99\": " + parsedInt);
        System.out.println("Parsed Double from \"45.67\": " + parsedDouble);
    }
}
