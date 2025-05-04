import java.util.Scanner;

public class lab2HomeTask1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get month input from the user
        System.out.print("Enter the current month (1-12): ");
        int month = input.nextInt();

        // Get hemisphere input from the user (Northern or Southern)
        System.out.print("Enter your hemisphere (Northern/Southern): ");
        String hemisphere = input.next().toLowerCase();

        // Validate the month input
        if (month < 1 || month > 12) {
            System.out.println("Invalid month entered.");
        } else {
            String season = "";
            
            // Switch statement to determine the season based on the month
            switch (month) {
                case 12: // December
                case 1:  // January
                case 2:  // February
                    season = "Winter";  // Default for Northern Hemisphere
                    break;
                case 3:  // March
                case 4:  // April
                case 5:  // May
                    season = "Spring";  // Default for Northern Hemisphere
                    break;
                case 6:  // June
                case 7:  // July
                case 8:  // August
                    season = "Summer";  // Default for Northern Hemisphere
                    break;
                case 9:  // September
                case 10: // October
                case 11: // November
                    season = "Fall";  // Default for Northern Hemisphere
                    break;
                default:
                    season = "Invalid month";
            }

            // Adjust season based on hemisphere
            if (hemisphere.equals("southern")) {
                switch (season) {
                    case "Winter":
                        season = "Summer";
                        break;
                    case "Spring":
                        season = "Fall";
                        break;
                    case "Summer":
                        season = "Winter";
                        break;
                    case "Fall":
                        season = "Spring";
                        break;
                }
            }

            System.out.println("Season: " + season);
        }

        input.close();
    }
}
