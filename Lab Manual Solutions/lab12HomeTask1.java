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

public class lab12HomeTask1 extends Application {

    // Store predefined credentials and roles
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        users.put("admin", new User("admin123", "Admin"));
        users.put("manager", new User("manager123", "Manager"));
        users.put("user", new User("user123", "User"));

        // UI Elements
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

            // Correct credentials and role
            lblMessage.setText("Login successful!");
            primaryStage.close();

            switch (selectedRole) {
                case "Admin":
                    showAdminDashboard(username);
                    break;
                case "Manager":
                    showManagerPage(username);
                    break;
                case "User":
                    showUserWelcome(username);
                    break;
            }
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(30));
        Text title = new Text("Role-Based Login");
        title.setFont(Font.font(22));
        vbox.getChildren().addAll(title, grid);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    private void showAdminDashboard(String username) {
        Stage stage = new Stage();
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        Label label = new Label("Admin Dashboard");
        label.setFont(Font.font(18));
        vbox.getChildren().addAll(label,
                new Label("Welcome, " + username + "!"),
                new Label("Here you can manage all users..."));

        Scene scene = new Scene(vbox, 350, 200);
        stage.setScene(scene);
        stage.setTitle("Admin Panel");
        stage.show();
    }

    private void showManagerPage(String username) {
        Stage stage = new Stage();
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        Label label = new Label("Manager Panel");
        label.setFont(Font.font(18));
        vbox.getChildren().addAll(label,
                new Label("Hello " + username + "!"),
                new Label("You can view/edit your team's info here."));

        Scene scene = new Scene(vbox, 350, 200);
        stage.setScene(scene);
        stage.setTitle("Manager Panel");
        stage.show();
    }

    private void showUserWelcome(String username) {
        Stage stage = new Stage();
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        Label label = new Label("User Dashboard");
        label.setFont(Font.font(18));
        vbox.getChildren().addAll(label,
                new Label("Welcome, " + username + "!"),
                new Label("Enjoy your access."));

        Scene scene = new Scene(vbox, 350, 200);
        stage.setScene(scene);
        stage.setTitle("User Panel");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Simple user model
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


// Predefined Credentials:

// Admin: admin / admin123

// Manager: manager / manager123

// User: user / user123