import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class lab12HomeTask2 extends Application {

    private final Map<String, User> users = new HashMap<>();
    private int otp;
    private int attemptsLeft = 3;

    @Override
    public void start(Stage primaryStage) {
        users.put("admin", new User("admin123", "Admin"));
        users.put("manager", new User("manager123", "Manager"));
        users.put("user", new User("user123", "User"));

        Label lblUsername = new Label("Username:");
        TextField txtUsername = new TextField();

        Label lblPassword = new Label("Password:");
        PasswordField txtPassword = new PasswordField();

        Label lblRole = new Label("Role:");
        ComboBox<String> cbRole = new ComboBox<>();
        cbRole.getItems().addAll("Admin", "Manager", "User");

        Button btnLogin = new Button("Login");
        Label lblMessage = new Label();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(lblUsername, 0, 0);
        grid.add(txtUsername, 1, 0);
        grid.add(lblPassword, 0, 1);
        grid.add(txtPassword, 1, 1);
        grid.add(lblRole, 0, 2);
        grid.add(cbRole, 1, 2);
        grid.add(btnLogin, 1, 3);
        grid.add(lblMessage, 1, 4);

        btnLogin.setOnAction(e -> {
            String username = txtUsername.getText().trim();
            String password = txtPassword.getText().trim();
            String selectedRole = cbRole.getValue();

            if (username.isEmpty() || password.isEmpty() || selectedRole == null) {
                lblMessage.setText("Please fill all fields.");
                return;
            }

            if (!users.containsKey(username)) {
                lblMessage.setText("Username not found.");
                return;
            }

            User user = users.get(username);
            if (!user.getPassword().equals(password)) {
                lblMessage.setText("Incorrect password.");
                return;
            }

            if (!user.getRole().equals(selectedRole)) {
                lblMessage.setText("Role mismatch.");
                return;
            }

            // If credentials are valid → go to OTP verification
            generateOTP();
            showOTPDialog(primaryStage, selectedRole, username);
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(30));
        Text title = new Text("Login with Two-Step Authentication");
        title.setFont(Font.font(20));
        vbox.getChildren().addAll(title, grid);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    private void generateOTP() {
        otp = new Random().nextInt(9000) + 1000; // 4-digit OTP
        System.out.println("Your OTP is: " + otp); // Simulate sending via SMS/email
        attemptsLeft = 3;
    }

    private void showOTPDialog(Stage stage, String role, String username) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("OTP Verification");

        Label lbl = new Label("Enter the 4-digit OTP sent to you:");
        TextField otpField = new TextField();
        Label feedback = new Label();

        ButtonType verifyButton = new ButtonType("Verify", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(verifyButton, ButtonType.CANCEL);

        VBox vbox = new VBox(10, lbl, otpField, feedback);
        vbox.setPadding(new Insets(20));
        dialog.getDialogPane().setContent(vbox);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == verifyButton) {
                try {
                    int enteredOtp = Integer.parseInt(otpField.getText().trim());
                    if (enteredOtp == otp) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login Successful!");
                        alert.showAndWait();
                        dialog.close();
                        stage.close();
                        openDashboard(role, username);
                    } else {
                        attemptsLeft--;
                        if (attemptsLeft > 0) {
                            feedback.setText("Incorrect OTP. Attempts left: " + attemptsLeft);
                            showOTPDialog(stage, role, username); // reopen dialog
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Too many failed attempts. Access locked.");
                            alert.showAndWait();
                        }
                    }
                } catch (NumberFormatException ex) {
                    feedback.setText("Please enter a valid number.");
                    showOTPDialog(stage, role, username);
                }
            }
            return null;
        });

        dialog.showAndWait();
    }

    private void openDashboard(String role, String username) {
        Stage dashboard = new Stage();
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));

        Label welcome = new Label("Welcome " + username + "! Role: " + role);
        welcome.setFont(Font.font(16));

        Label info = new Label();

        switch (role) {
            case "Admin" -> info.setText("You can manage all users here.");
            case "Manager" -> info.setText("You can manage your team here.");
            case "User" -> info.setText("Welcome to your account.");
        }

        vbox.getChildren().addAll(welcome, info);

        Scene scene = new Scene(vbox, 350, 200);
        dashboard.setScene(scene);
        dashboard.setTitle(role + " Dashboard");
        dashboard.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    static class User {
        private final String password;
        private final String role;

        public User(String password, String role) {
            this.password = password;
            this.role = role;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }
    }
}
