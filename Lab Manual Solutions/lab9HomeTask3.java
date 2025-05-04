import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class lab9HomeTask3 {
    public static void main(String[] args) {
        // Specify the file path
        String filePath = "sample.txt"; // You can change this to any file path
        
        // Using try-with-resources to automatically close the file after reading
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Print each line to the console
            }
        } catch (FileNotFoundException e) {
            // This exception is thrown if the file does not exist at the specified path
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            // This exception is thrown for general I/O errors
            System.out.println("Error: An I/O error occurred while reading the file.");
        }
    }
}
