// File: lab10Task1.java

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class lab10Task1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Title Label
        Label titleLabel = new Label("User Information Form");
        titleLabel.setFont(Font.font("Verdana", 24));

        // Text Field for User Input
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");

        // ComboBox for selecting a city
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Karachi", "Lahore", "Islamabad", "Quetta");
        cityComboBox.setPromptText("Select your city");

        // DatePicker
        DatePicker datePicker = new DatePicker();

        // Buttons
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        // HBox for buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(submitButton, cancelButton);

        // VBox for layout
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, nameField, cityComboBox, datePicker, buttonBox);

        // Scene and Stage setup
        Scene scene = new Scene(layout, 400, 300);
        stage.setTitle("JavaFX User Form");
        stage.setScene(scene);
        stage.show();
    }
}
