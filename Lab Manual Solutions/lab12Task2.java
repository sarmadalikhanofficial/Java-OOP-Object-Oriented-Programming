import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class lab12Task2 extends Application {

    private final String USERNAME = "admin";
    private final String PASSWORD = "password";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Form");

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
        Label lblMessage = new Label();

        // Forgot Password
        Hyperlink forgotLink = new Hyperlink("Forgot Password?");
        forgotLink.setBorder(Border.EMPTY);
        forgotLink.setPadding(new Insets(5, 0, 0, 0));

        forgotLink.setOnAction(e -> showForgotPasswordDialog());

        grid.add(lblUser, 0, 0);
        grid.add(txtUser, 1, 0);
        grid.add(lblPass, 0, 1);
        grid.add(txtPass, 1, 1);
        grid.add(btnLogin, 1, 2);
        grid.add(forgotLink, 1, 3);
        grid.add(lblMessage, 1, 4);

        // Real-time input validation
        txtUser.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.trim().isEmpty()) {
                lblMessage.setText("Username cannot be empty.");
                lblMessage.setTextFill(Color.RED);
            } else {
                lblMessage.setText("");
            }
        });

        txtPass.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.trim().isEmpty()) {
                lblMessage.setText("Password cannot be empty.");
                lblMessage.setTextFill(Color.RED);
            } else {
                lblMessage.setText("");
            }
        });

        btnLogin.setOnAction(e -> {
            String enteredUser = txtUser.getText().trim();
            String enteredPass = txtPass.getText().trim();

            if (enteredUser.isEmpty() || enteredPass.isEmpty()) {
                lblMessage.setText("Please fill in both fields.");
                lblMessage.setTextFill(Color.RED);
            } else if (enteredUser.equals(USERNAME) && enteredPass.equals(PASSWORD)) {
                lblMessage.setText("Login successful!");
                lblMessage.setTextFill(Color.GREEN);
                showMainApp();
                primaryStage.close();
            } else {
                lblMessage.setText("Invalid username or password.");
                lblMessage.setTextFill(Color.RED);
            }

            txtUser.clear();
            txtPass.clear();
        });

        root.setTop(hbox);
        root.setCenter(grid);

        Scene scene = new Scene(root, 400, 320);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // Simulated Password Recovery
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showMainApp() {
        Stage stage = new Stage();
        stage.setTitle("Main Application");

        Label welcome = new Label("Welcome to the main application!");
        welcome.setFont(Font.font("Arial", 18));
        welcome.setPadding(new Insets(20));

        Scene scene = new Scene(welcome, 350, 150);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
