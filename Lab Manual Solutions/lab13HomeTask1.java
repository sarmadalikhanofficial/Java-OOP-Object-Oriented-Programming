
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class lab13HomeTask1 extends Application {

    private TextField nameField, emailField, addressField;
    private ComboBox<String> genderBox;
    private DatePicker dobPicker;
    private TableView<UserProfile> table;

    @Override
    public void start(Stage stage) {
        // Input Fields
        nameField = new TextField();
        emailField = new TextField();
        addressField = new TextField();
        genderBox = new ComboBox<>(FXCollections.observableArrayList("Male", "Female", "Other"));
        genderBox.setPromptText("Select Gender");
        dobPicker = new DatePicker();

        Button saveButton = new Button("Save Profile");
        saveButton.setOnAction(e -> saveProfile());

        // Table View
        table = new TableView<>();
        table.setItems(FXCollections.observableArrayList());
        setupTableColumns();

        Button loadButton = new Button("Load Profiles");
        loadButton.setOnAction(e -> loadProfiles());

        // Layout
        GridPane form = new GridPane();
        form.setPadding(new Insets(15));
        form.setVgap(10);
        form.setHgap(10);

        form.add(new Label("Full Name:"), 0, 0); form.add(nameField, 1, 0);
        form.add(new Label("Email Address:"), 0, 1); form.add(emailField, 1, 1);
        form.add(new Label("Gender:"), 0, 2); form.add(genderBox, 1, 2);
        form.add(new Label("Address (Street, City):"), 0, 3); form.add(addressField, 1, 3);
        form.add(new Label("Date of Birth:"), 0, 4); form.add(dobPicker, 1, 4);
        form.add(saveButton, 1, 5);
        form.add(loadButton, 1, 6);
        form.add(table, 0, 7, 2, 1);

        Scene scene = new Scene(form, 700, 550);
        stage.setTitle("User Profile Management System");
        stage.setScene(scene);
        stage.show();
    }

    private void setupTableColumns() {
        TableColumn<UserProfile, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().name));

        TableColumn<UserProfile, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().email));

        TableColumn<UserProfile, String> genderCol = new TableColumn<>("Gender");
        genderCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().gender));

        TableColumn<UserProfile, String> addressCol = new TableColumn<>("Address");
        addressCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().address));

        TableColumn<UserProfile, String> dobCol = new TableColumn<>("Date of Birth");
        dobCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().dob));

        table.getColumns().addAll(nameCol, emailCol, genderCol, addressCol, dobCol);
    }

    private void saveProfile() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String gender = genderBox.getValue();
        String address = addressField.getText().trim();
        LocalDate dob = dobPicker.getValue();

        if (name.isEmpty() || email.isEmpty() || gender == null || address.isEmpty() || dob == null) {
            showAlert("All fields are required.");
            return;
        }

        if (!isValidEmail(email)) {
            showAlert("Invalid email format.");
            return;
        }

        if (!address.contains(",")) {
            showAlert("Address must contain both street and city, separated by a comma.");
            return;
        }

        String record = name + "," + email + "," + gender + "," + address + "," + dob;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_profiles.txt", true))) {
            writer.write(record);
            writer.newLine();
            showAlert("User profile saved successfully!");
            clearForm();
        } catch (IOException e) {
            showAlert("Error writing to file: " + e.getMessage());
        }
    }

    private void loadProfiles() {
        table.getItems().clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("user_profiles.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 5);
                if (parts.length == 5) {
                    table.getItems().add(new UserProfile(parts[0], parts[1], parts[2], parts[3], parts[4]));
                }
            }
        } catch (IOException e) {
            showAlert("Could not read file: " + e.getMessage());
        }
    }

    private boolean isValidEmail(String email) {
        String pattern = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";
        return Pattern.matches(pattern, email.toLowerCase());
    }

    private void clearForm() {
        nameField.clear();
        emailField.clear();
        genderBox.setValue(null);
        addressField.clear();
        dobPicker.setValue(null);
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    // Helper class
    static class UserProfile {
        String name, email, gender, address, dob;
        UserProfile(String name, String email, String gender, String address, String dob) {
            this.name = name;
            this.email = email;
            this.gender = gender;
            this.address = address;
            this.dob = dob;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
