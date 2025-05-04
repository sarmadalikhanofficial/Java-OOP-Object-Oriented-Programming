import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class lab10Task5 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Components
        TextField nameField = new TextField();
        Button helloButton = new Button("Say Hello");
        Label greetingLabel = new Label("Welcome!");

        // Button click handler
        helloButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                greetingLabel.setText("Hello, " + name + "!");
            } else {
                greetingLabel.setText("Please enter your name.");
            }
        });

        // Layout
        VBox root = new VBox(10, nameField, helloButton, greetingLabel);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Scene and Stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Greeting App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
