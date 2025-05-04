import java.util.Scanner;

public class lab2Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // take temperature input
        System.out.print("Enter the current temperature (°C): ");
        int temperature = input.nextInt();
        input.nextLine(); // consume the newline

        // take weather condition input
        System.out.print("Enter the weather condition (rainy/sunny): ");
        String weather = input.nextLine().toLowerCase();

        // give advice based on temperature and weather
        if (temperature < 0) {
            if (weather.equals("rainy")) {
                System.out.println("Advice: Wear a heavy coat and take an umbrella.");
            } else if (weather.equals("sunny")) {
                System.out.println("Advice: Wear a heavy coat and sunglasses.");
            }
        } else if (temperature >= 0 && temperature <= 10) {
            if (weather.equals("rainy")) {
                System.out.println("Advice: Wear a warm jacket and take an umbrella.");
            } else if (weather.equals("sunny")) {
                System.out.println("Advice: Wear a warm jacket and sunglasses.");
            }
        } else if (temperature >= 11 && temperature <= 20) {
            if (weather.equals("rainy")) {
                System.out.println("Advice: Wear a light jacket and take an umbrella.");
            } else if (weather.equals("sunny")) {
                System.out.println("Advice: Wear a light jacket and sunglasses.");
            }
        } else if (temperature > 20) {
            if (weather.equals("rainy")) {
                System.out.println("Advice: Wear light clothing and take an umbrella.");
            } else if (weather.equals("sunny")) {
                System.out.println("Advice: Wear light clothing and sunglasses.");
            }
        } else {
            System.out.println("Invalid input.");
        }

        input.close();
    }
}
