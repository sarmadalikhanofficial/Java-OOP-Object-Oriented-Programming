import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class lab10Task7 extends Application {

    private int counter = 0;  // Counter variable to keep track of the number

    @Override
    public void start(Stage primaryStage) {
        // Create a Label to display the counter value
        Label counterLabel = new Label("0");
        
        // Create a Button to increment the counter
        Button incrementButton = new Button("Increment");
        
        // Set up the button's event handler
        incrementButton.setOnAction(e -> {
            // Increment the counter and update the label
            counter++;
            counterLabel.setText(String.valueOf(counter));
        });

        // Create a layout to arrange the label and button
        VBox layout = new VBox(10);
        layout.getChildren().addAll(counterLabel, incrementButton);

        // Create the scene and set it on the primary stage
        Scene scene = new Scene(layout, 200, 150);
        primaryStage.setTitle("Increment Counter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
