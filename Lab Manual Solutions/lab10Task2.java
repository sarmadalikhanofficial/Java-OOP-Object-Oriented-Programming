

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class lab10Task2 extends Application {

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

        // DatePicker for DOB
        DatePicker datePicker = new DatePicker();

        // CheckBoxes for communication preferences
        CheckBox emailCheckBox = new CheckBox("Email");
        CheckBox phoneCheckBox = new CheckBox("Phone");
        CheckBox smsCheckBox = new CheckBox("SMS");

        // Grouping checkboxes
        VBox checkBoxGroup = new VBox(5, new Label("Preferred Communication:"), emailCheckBox, phoneCheckBox, smsCheckBox);

        // Buttons
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        // HBox for buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(submitButton, cancelButton);

        // VBox for layout
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, nameField, cityComboBox, datePicker, checkBoxGroup, buttonBox);

        // Submit button action
        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String city = cityComboBox.getValue();
            String dob = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "Not selected";

            StringBuilder communicationModes = new StringBuilder();
            if (emailCheckBox.isSelected()) communicationModes.append("Email ");
            if (phoneCheckBox.isSelected()) communicationModes.append("Phone ");
            if (smsCheckBox.isSelected()) communicationModes.append("SMS ");

            System.out.println("Submitted Information:");
            System.out.println("Name: " + name);
            System.out.println("City: " + city);
            System.out.println("Date of Birth: " + dob);
            System.out.println("Preferred Communication: " + (communicationModes.length() > 0 ? communicationModes.toString().trim() : "None"));
        });

        // Cancel button action
        cancelButton.setOnAction(e -> {
            nameField.clear();
            cityComboBox.getSelectionModel().clearSelection();
            datePicker.setValue(null);
            emailCheckBox.setSelected(false);
            phoneCheckBox.setSelected(false);
            smsCheckBox.setSelected(false);
        });

        // Scene and Stage setup
        Scene scene = new Scene(layout, 400, 400);
        stage.setTitle("JavaFX User Form");
        stage.setScene(scene);
        stage.show();
    }
}
