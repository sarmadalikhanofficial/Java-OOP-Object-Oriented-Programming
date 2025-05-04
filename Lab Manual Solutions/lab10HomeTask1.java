import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class lab10HomeTask1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Label for the title
        Label titleLabel = new Label("Temperature Converter");

        // Create TextField for Celsius and Fahrenheit inputs
        TextField celsiusField = new TextField();
        TextField fahrenheitField = new TextField();

        // Create a Label to display error messages
        Label errorLabel = new Label();

        // Create buttons for conversion
        Button toFahrenheitButton = new Button("Convert to Fahrenheit");
        Button toCelsiusButton = new Button("Convert to Celsius");

        // Add tooltips to guide users
        celsiusField.setTooltip(new javafx.scene.control.Tooltip("Enter temperature in Celsius"));
        fahrenheitField.setTooltip(new javafx.scene.control.Tooltip("Enter temperature in Fahrenheit"));

        // Convert Celsius to Fahrenheit
        toFahrenheitButton.setOnAction(e -> {
            try {
                double celsius = Double.parseDouble(celsiusField.getText());
                double fahrenheit = (celsius * 9 / 5) + 32;
                fahrenheitField.setText(String.format("%.2f", fahrenheit));
                errorLabel.setText("");
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input for Celsius");
            }
        });

        // Convert Fahrenheit to Celsius
        toCelsiusButton.setOnAction(e -> {
            try {
                double fahrenheit = Double.parseDouble(fahrenheitField.getText());
                double celsius = (fahrenheit - 32) * 5 / 9;
                celsiusField.setText(String.format("%.2f", celsius));
                errorLabel.setText("");
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid input for Fahrenheit");
            }
        });

        // Arrange components in a VBox layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(titleLabel, celsiusField, fahrenheitField, toFahrenheitButton, toCelsiusButton, errorLabel);

        // Set up the scene
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
