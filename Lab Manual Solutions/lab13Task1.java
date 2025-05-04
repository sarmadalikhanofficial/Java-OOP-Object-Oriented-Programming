import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class lab13Task1 extends Application {

    private TextField nameField, emailField, locationField;
    private DatePicker dobPicker;
    private ComboBox<String> educationBox;
    private ToggleGroup genderGroup;
    private TextArea outputArea;

    @Override
    public void start(Stage primaryStage) {
        // Input fields
        nameField = new TextField();
        emailField = new TextField();
        locationField = new TextField();
        dobPicker = new DatePicker();
        educationBox = new ComboBox<>();
        educationBox.getItems().addAll("Matric", "Intermediate", "Graduate", "Postgraduate");

        // Gender radio buttons
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        genderGroup = new ToggleGroup();
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);

        // Buttons
        Button registerBtn = new Button("Register");
        Button showBtn = new Button("Show Users");

        registerBtn.setOnAction(e -> registerUser());
        showBtn.setOnAction(e -> showUsers());

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);

        // Layout
        GridPane form = new GridPane();
        form.setPadding(new Insets(15));
        form.setVgap(10);
        form.setHgap(10);

        form.add(new Label("Name:"), 0, 0); form.add(nameField, 1, 0);
        form.add(new Label("Email:"), 0, 1); form.add(emailField, 1, 1);
        form.add(new Label("Gender:"), 0, 2); form.add(new HBox(10, male, female), 1, 2);
        form.add(new Label("Education:"), 0, 3); form.add(educationBox, 1, 3);
        form.add(new Label("Location:"), 0, 4); form.add(locationField, 1, 4);
        form.add(new Label("Date of Birth:"), 0, 5); form.add(dobPicker, 1, 5);
        form.add(new HBox(10, registerBtn, showBtn), 1, 6);
        form.add(outputArea, 0, 7, 2, 1);

        Scene scene = new Scene(form, 500, 500);
        primaryStage.setTitle("User Registration System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void registerUser() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String gender = "";
        if (genderGroup.getSelectedToggle() != null) {
            gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
        }
        String education = educationBox.getValue();
        String location = locationField.getText().trim();
        LocalDate dob = dobPicker.getValue();

        if (name.isEmpty() || email.isEmpty() || gender.isEmpty() || education == null || location.isEmpty() || dob == null) {
            showAlert("All fields are required.");
            return;
        }

        String record = String.format("%s,%s,%s,%s,%s,%s", name, email, gender, education, location, dob);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(record);
            writer.newLine();
            showAlert("User registered successfully!");
            clearForm();
        } catch (IOException e) {
            showAlert("Error writing to file.");
        }
    }

    private void showUsers() {
        StringBuilder content = new StringBuilder("Registered Users:\n\n");

        try (Scanner scanner = new Scanner(new File("users.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 6) {
                    content.append("Name: ").append(parts[0])
                            .append(", Email: ").append(parts[1])
                            .append(", Gender: ").append(parts[2])
                            .append(", Education: ").append(parts[3])
                            .append(", Location: ").append(parts[4])
                            .append(", DOB: ").append(parts[5])
                            .append("\n");
                }
            }
        } catch (FileNotFoundException e) {
            showAlert("No records found.");
            return;
        }

        outputArea.setText(content.toString());
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearForm() {
        nameField.clear();
        emailField.clear();
        genderGroup.selectToggle(null);
        educationBox.getSelectionModel().clearSelection();
        locationField.clear();
        dobPicker.setValue(null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
