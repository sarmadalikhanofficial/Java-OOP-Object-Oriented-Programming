import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class lab13Task2 extends Application {

    private TextField nameField, emailField;
    private ComboBox<String> statusBox;
    private TextArea outputArea;

    @Override
    public void start(Stage stage) {
        nameField = new TextField();
        emailField = new TextField();
        statusBox = new ComboBox<>();
        statusBox.getItems().addAll("Present", "Absent");

        Button submitBtn = new Button("Mark Attendance");
        Button showBtn = new Button("Show Attendance");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);

        submitBtn.setOnAction(e -> saveAttendance());
        showBtn.setOnAction(e -> displayAttendance());

        GridPane form = new GridPane();
        form.setPadding(new Insets(15));
        form.setVgap(10);
        form.setHgap(10);

        form.add(new Label("Name:"), 0, 0); form.add(nameField, 1, 0);
        form.add(new Label("Email:"), 0, 1); form.add(emailField, 1, 1);
        form.add(new Label("Attendance Status:"), 0, 2); form.add(statusBox, 1, 2);
        form.add(new HBox(10, submitBtn, showBtn), 1, 3);
        form.add(outputArea, 0, 4, 2, 1);

        Scene scene = new Scene(form, 500, 400);
        stage.setTitle("Community Attendance Tracker");
        stage.setScene(scene);
        stage.show();
    }

    private void saveAttendance() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String status = statusBox.getValue();

        if (name.isEmpty() || email.isEmpty() || status == null) {
            showAlert("All fields are required.");
            return;
        }

        String record = name + "," + email + "," + status;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("attendance.txt", true))) {
            writer.write(record);
            writer.newLine();
            showAlert("Attendance marked successfully!");
            clearForm();
        } catch (IOException e) {
            showAlert("Error writing to file.");
        }
    }

    private void displayAttendance() {
        StringBuilder records = new StringBuilder();
        int total = 0, present = 0, absent = 0;

        try (Scanner scanner = new Scanner(new File("attendance.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 3) {
                    total++;
                    String status = parts[2];
                    if (status.equalsIgnoreCase("Present")) present++;
                    else if (status.equalsIgnoreCase("Absent")) absent++;

                    records.append("Name: ").append(parts[0])
                           .append(", Email: ").append(parts[1])
                           .append(", Status: ").append(status)
                           .append("\n");
                }
            }

            records.append("\nTotal Attendees: ").append(total)
                   .append("\nPresent: ").append(present)
                   .append("\nAbsent: ").append(absent);

            outputArea.setText(records.toString());

        } catch (FileNotFoundException e) {
            showAlert("No attendance records found.");
        }
    }

    private void clearForm() {
        nameField.clear();
        emailField.clear();
        statusBox.getSelectionModel().clearSelection();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
