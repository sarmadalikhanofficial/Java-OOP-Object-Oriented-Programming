import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class lab10Task3 extends Application {

    private TextField usernameField;
    private PasswordField passwordField;
    private TextField emailField;
    private Label errorLabel;

    private Label profileUsernameLabel = new Label();
    private Label profileEmailLabel = new Label();

    private Scene registrationScene, profileScene;

    @Override
    public void start(Stage stage) {

        // REGISTRATION SCENE
        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        usernameField.setPromptText("Enter username");

        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");

        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        emailField.setPromptText("Enter email");

        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        Button registerButton = new Button("Register");

        VBox regLayout = new VBox(10);
        regLayout.setPadding(new Insets(20));
        regLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField,
                emailLabel, emailField, errorLabel, registerButton);

        // DARK THEME STYLING
        regLayout.setStyle("-fx-background-color: #1e1e1e;");
        usernameLabel.setStyle("-fx-text-fill: white;");
        passwordLabel.setStyle("-fx-text-fill: white;");
        emailLabel.setStyle("-fx-text-fill: white;");
        usernameField.setStyle("-fx-control-inner-background: #2e2e2e; -fx-text-fill: white;");
        passwordField.setStyle("-fx-control-inner-background: #2e2e2e; -fx-text-fill: white;");
        emailField.setStyle("-fx-control-inner-background: #2e2e2e; -fx-text-fill: white;");
        registerButton.setStyle("-fx-background-color: #3c8dbc; -fx-text-fill: white; -fx-font-weight: bold;");

        registrationScene = new Scene(regLayout, 350, 350);

        // PROFILE SCENE
        Label profileTitle = new Label("User Profile");
        Button backButton = new Button("Back to Registration");

        VBox profileLayout = new VBox(15);
        profileLayout.setPadding(new Insets(20));
        profileLayout.getChildren().addAll(profileTitle, profileUsernameLabel, profileEmailLabel, backButton);

        profileLayout.setStyle("-fx-background-color: #1e1e1e;");
        profileTitle.setStyle("-fx-text-fill: white; -fx-font-size: 18;");
        profileUsernameLabel.setStyle("-fx-text-fill: white;");
        profileEmailLabel.setStyle("-fx-text-fill: white;");
        backButton.setStyle("-fx-background-color: #3c8dbc; -fx-text-fill: white; -fx-font-weight: bold;");

        profileScene = new Scene(profileLayout, 350, 300);

        // EVENT HANDLERS
        registerButton.setOnAction(e -> {
            if (validateInput()) {
                profileUsernameLabel.setText("Username: " + usernameField.getText());
                profileEmailLabel.setText("Email: " + emailField.getText());
                applyFadeTransition(stage, profileScene);
            }
        });

        backButton.setOnAction(e -> {
            applyFadeTransition(stage, registrationScene);
        });

        stage.setTitle("User Registration");
        stage.setScene(registrationScene);
        stage.show();
    }

    private boolean validateInput() {
        if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty() || emailField.getText().isEmpty()) {
            errorLabel.setText("All fields are required.");
            return false;
        }
        errorLabel.setText("");
        return true;
    }

    private void applyFadeTransition(Stage stage, Scene nextScene) {
        FadeTransition fade = new FadeTransition(Duration.millis(400), stage.getScene().getRoot());
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.setOnFinished(event -> {
            stage.setScene(nextScene);
            FadeTransition fadeIn = new FadeTransition(Duration.millis(400), nextScene.getRoot());
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });
        fade.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
