class lab5Task1 {
    public static void main(String[] args) {
        // Temperature readings for 7 days
        double[] temperatures = {25.5, 28.0, 23.5, 24.0, 26.5, 29.0, 27.5};

        // Calculate the average temperature
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }
        double average = sum / temperatures.length;

        // Find the highest and lowest temperatures
        double highest = temperatures[0];
        double lowest = temperatures[0];

        for (double temp : temperatures) {
            if (temp > highest) {
                highest = temp;
            }
            if (temp < lowest) {
                lowest = temp;
            }
        }

        // Print the summary report
        System.out.println("Temperature Analysis Report:");
        System.out.println("-----------------------------");
        System.out.println("Average Temperature: " + average + " °C");
        System.out.println("Highest Temperature: " + highest + " °C");
        System.out.println("Lowest Temperature: " + lowest + " °C");
        System.out.println("-----------------------------");
        System.out.println("Daily Temperatures:");

        // Print daily temperatures
        for (int i = 0; i < temperatures.length; i++) {
            System.out.println("Day " + (i + 1) + ": " + temperatures[i] + " °C");
        }
    }
}