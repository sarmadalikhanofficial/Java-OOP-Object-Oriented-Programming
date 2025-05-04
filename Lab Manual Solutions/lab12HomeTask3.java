import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class lab12HomeTask3 extends Application {

    Stage window;
    Scene step1Scene, step2Scene, step3Scene, summaryScene;

    // Step 1 fields
    TextField nameField = new TextField();
    TextField emailField = new TextField();
    TextField phoneField = new TextField();

    // Step 2 fields
    TextField streetField = new TextField();
    TextField cityField = new TextField();
    TextField zipField = new TextField();

    // Step 3 fields
    TextField usernameField = new TextField();
    PasswordField passwordField = new PasswordField();

    Label summaryLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Multi-Step Registration");

        // Step 1 layout
        VBox step1Layout = new VBox(10);
        step1Layout.setPadding(new Insets(20));
        step1Layout.getChildren().addAll(
                new Label("Name:"), nameField,
                new Label("Email:"), emailField,
                new Label("Phone Number:"), phoneField,
                createNextButtonStep1()
        );
        step1Scene = new Scene(step1Layout, 300, 300);

        // Step 2 layout
        VBox step2Layout = new VBox(10);
        step2Layout.setPadding(new Insets(20));
        Button back1 = new Button("Back");
        back1.setOnAction(e -> window.setScene(step1Scene));
        step2Layout.getChildren().addAll(
                new Label("Street:"), streetField,
                new Label("City:"), cityField,
                new Label("ZIP Code:"), zipField,
                new HBox(10, back1, createNextButtonStep2())
        );
        step2Scene = new Scene(step2Layout, 300, 300);

        // Step 3 layout
        VBox step3Layout = new VBox(10);
        step3Layout.setPadding(new Insets(20));
        Button back2 = new Button("Back");
        back2.setOnAction(e -> window.setScene(step2Scene));
        step3Layout.getChildren().addAll(
                new Label("Username:"), usernameField,
                new Label("Password:"), passwordField,
                new HBox(10, back2, createNextButtonStep3())
        );
        step3Scene = new Scene(step3Layout, 300, 300);

        // Summary Layout
        VBox summaryLayout = new VBox(15);
        summaryLayout.setPadding(new Insets(20));
        Button finishButton = new Button("Finish");
        finishButton.setOnAction(e -> saveToFile());
        summaryLayout.getChildren().addAll(
                new Label("Registration Summary:"),
                summaryLabel,
                finishButton
        );
        summaryScene = new Scene(summaryLayout, 350, 300);

        window.setScene(step1Scene);
        window.show();
    }

    private Button createNextButtonStep1() {
        Button next = new Button("Next");
        next.setOnAction(e -> {
            if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty()) {
                showAlert("All fields in Step 1 must be filled!");
            } else {
                window.setScene(step2Scene);
            }
        });
        return next;
    }

    private Button createNextButtonStep2() {
        Button next = new Button("Next");
        next.setOnAction(e -> {
            if (streetField.getText().isEmpty() || cityField.getText().isEmpty() || zipField.getText().isEmpty()) {
                showAlert("All fields in Step 2 must be filled!");
            } else {
                window.setScene(step3Scene);
            }
        });
        return next;
    }

    private Button createNextButtonStep3() {
        Button next = new Button("Next");
        next.setOnAction(e -> {
            if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                showAlert("All fields in Step 3 must be filled!");
            } else {
                // Prepare summary
                summaryLabel.setText(
                        "Name: " + nameField.getText() + "\n" +
                        "Email: " + emailField.getText() + "\n" +
                        "Phone: " + phoneField.getText() + "\n" +
                        "Street: " + streetField.getText() + "\n" +
                        "City: " + cityField.getText() + "\n" +
                        "ZIP: " + zipField.getText() + "\n" +
                        "Username: " + usernameField.getText()
                );
                window.setScene(summaryScene);
            }
        });
        return next;
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter("user_registration.txt")) {
            writer.write(summaryLabel.getText());
            showAlert("Registration saved to file successfully!");
            window.setScene(step1Scene);
            clearAllFields();
        } catch (IOException e) {
            showAlert("Failed to save file.");
        }
    }

    private void clearAllFields() {
        nameField.clear();
        emailField.clear();
        phoneField.clear();
        streetField.clear();
        cityField.clear();
        zipField.clear();
        usernameField.clear();
        passwordField.clear();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
