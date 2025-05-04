import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class lab10Task4 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a Button
        Button button = new Button("Click Me!");
        button.setOnAction(e -> System.out.println("Hello, JavaFX!"));

        // Layout and Scene
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 200);

        // Stage setup
        primaryStage.setTitle("Hello JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch JavaFX application
    }
}
