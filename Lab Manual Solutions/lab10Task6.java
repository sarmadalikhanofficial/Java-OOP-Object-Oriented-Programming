
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class lab10Task6 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane and a Button
        Pane root = new Pane();
        Button changeColorButton = new Button("Change Color");
        changeColorButton.setLayoutX(100);
        changeColorButton.setLayoutY(100);

        // Button click handler
        changeColorButton.setOnAction(e -> {
            // Generate a random color
            Color randomColor = generateRandomColor();
            // Set the background color of the Pane
            root.setStyle("-fx-background-color: #" + colorToHex(randomColor) + ";");
        });

        // Add the button to the root pane
        root.getChildren().add(changeColorButton);

        // Scene and Stage
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Change Background Color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Generate a random color
    private Color generateRandomColor() {
        Random rand = new Random();
        return new Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), 1.0);
    }

    // Convert Color to Hex string
    private String colorToHex(Color color) {
        return String.format("%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
