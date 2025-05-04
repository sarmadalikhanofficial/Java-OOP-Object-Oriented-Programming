import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class lab10HomeTask3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create TextFields for user input
        TextField num1Field = new TextField();
        TextField num2Field = new TextField();
        
        // Create a Label to display the result
        Label resultLabel = new Label("Result: ");
        
        // Create Buttons for the operations
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");

        // Create HBox for the buttons (arrange buttons horizontally)
        HBox buttonBox = new HBox(10, addButton, subtractButton, multiplyButton, divideButton);
        
        // Create VBox for the overall layout (arrange everything vertically)
        VBox layout = new VBox(10, num1Field, num2Field, buttonBox, resultLabel);
        
        // Add functionality to the buttons
        addButton.setOnAction(e -> performOperation(num1Field, num2Field, resultLabel, "+"));
        subtractButton.setOnAction(e -> performOperation(num1Field, num2Field, resultLabel, "-"));
        multiplyButton.setOnAction(e -> performOperation(num1Field, num2Field, resultLabel, "*"));
        divideButton.setOnAction(e -> performOperation(num1Field, num2Field, resultLabel, "/"));
        
        // Set up the scene
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to handle calculations
    private void performOperation(TextField num1Field, TextField num2Field, Label resultLabel, String operation) {
        try {
            // Get numbers from the TextFields
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            
            double result = 0;
            // Perform the operation based on the button clicked
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    // Handle division by zero
                    if (num2 == 0) {
                        resultLabel.setText("Error: Division by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            // Display the result
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Invalid input");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
