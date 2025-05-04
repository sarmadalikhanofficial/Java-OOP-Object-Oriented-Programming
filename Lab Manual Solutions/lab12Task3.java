import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class lab12Task3 extends Application {

    private Map<String, User> users = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10, 50, 50, 50));

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20, 20, 20, 30));
        Text title = new Text("Login Form");
        title.setFont(Font.font("Verdana", 30));
        title.setEffect(new DropShadow());
        hbox.getChildren().add(title);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setEffect(new Reflection());

        Label lblUser = new Label("Username:");
        TextField txtUser = new TextField();

        Label lblPass = new Label("Password:");
        PasswordField txtPass = new PasswordField();

        Button btnLogin = new Button("Login");
        Button btnRegister = new Button("Register");

        Label lblMessage = new Label();

        Hyperlink forgotLink = new Hyperlink("Forgot Password?");
        forgotLink.setBorder(Border.EMPTY);
        forgotLink.setPadding(new Insets(5, 0, 0, 0));
        forgotLink.setOnAction(e -> showForgotPasswordDialog());

        grid.add(lblUser, 0, 0);
        grid.add(txtUser, 1, 0);
        grid.add(lblPass, 0, 1);
        grid.add(txtPass, 1, 1);
        grid.add(btnLogin, 1, 2);
        grid.add(btnRegister, 1, 3);
        grid.add(forgotLink, 1, 4);
        grid.add(lblMessage, 1, 5);

        // Hardcoded default user
        users.put("admin", new User("admin", "password", "admin@email.com"));

        btnLogin.setOnAction(e -> {
            String username = txtUser.getText().trim();
            String password = txtPass.getText().trim();

            if (username.isEmpty() || password.isEmpty()) {
                lblMessage.setText("Please fill in both fields.");
                lblMessage.setTextFill(Color.RED);
                return;
            }

            if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
                lblMessage.setText("Login successful!");
                lblMessage.setTextFill(Color.GREEN);
                showMainApp(username);
                primaryStage.close();
            } else {
                lblMessage.setText("Invalid credentials.");
                lblMessage.setTextFill(Color.RED);
            }

            txtUser.clear();
            txtPass.clear();
        });

        btnRegister.setOnAction(e -> showRegisterForm(primaryStage));

        root.setTop(hbox);
        root.setCenter(grid);

        Scene scene = new Scene(root, 420, 370);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void showRegisterForm(Stage loginStage) {
        Stage registerStage = new Stage();
        registerStage.setTitle("Register");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label lblUsername = new Label("Username:");
        TextField txtUsername = new TextField();

        Label lblPassword = new Label("Password:");
        PasswordField txtPassword = new PasswordField();

        Label lblEmail = new Label("Email:");
        TextField txtEmail = new TextField();

        Button btnSubmit = new Button("Submit");
        Label lblStatus = new Label();

        grid.add(lblUsername, 0, 0);
        grid.add(txtUsername, 1, 0);
        grid.add(lblPassword, 0, 1);
        grid.add(txtPassword, 1, 1);
        grid.add(lblEmail, 0, 2);
        grid.add(txtEmail, 1, 2);
        grid.add(btnSubmit, 1, 3);
        grid.add(lblStatus, 1, 4);

        btnSubmit.setOnAction(e -> {
            String username = txtUsername.getText().trim();
            String password = txtPassword.getText().trim();
            String email = txtEmail.getText().trim();

            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                lblStatus.setText("All fields are required.");
                lblStatus.setTextFill(Color.RED);
                return;
            }

            if (users.containsKey(username)) {
                lblStatus.setText("Username already exists.");
                lblStatus.setTextFill(Color.RED);
                return;
            }

            if (!isValidEmail(email)) {
                lblStatus.setText("Invalid email format.");
                lblStatus.setTextFill(Color.RED);
                return;
            }

            users.put(username, new User(username, password, email));
            lblStatus.setText("Registration successful!");
            lblStatus.setTextFill(Color.GREEN);

            registerStage.close();
            showAlert("Success", "Account created. Please log in.");
        });

        Scene scene = new Scene(grid, 350, 250);
        registerStage.setScene(scene);
        registerStage.setResizable(false);
        registerStage.show();
    }

    private boolean isValidEmail(String email) {
        String regex = "^(.+)@(.+)$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    private void showForgotPasswordDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Password Recovery");
        dialog.setHeaderText("Forgot Password?");
        dialog.setContentText("Enter your registered email:");

        dialog.showAndWait().ifPresent(email -> {
            if (!email.trim().isEmpty()) {
                showAlert("Password Reset", "A password reset link has been sent to: " + email);
            } else {
                showAlert("Error", "Email cannot be empty.");
            }
        });
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void showMainApp(String username) {
        Stage stage = new Stage();
        stage.setTitle("Welcome");

        Label welcome = new Label("Welcome, " + username + "!");
        welcome.setFont(Font.font("Arial", 18));
        welcome.setPadding(new Insets(20));

        Scene scene = new Scene(welcome, 300, 150);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // User model
    class User {
        private final String username;
        private final String password;
        private final String email;

        public User(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        public String getPassword() {
            return password;
        }
    }
}
