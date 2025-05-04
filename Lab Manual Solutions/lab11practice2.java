// 2. BorderPane Example 
// Create an application that uses BorderPane to display components in various sections. 
// Steps: 
// 1.	Implement the above code in a class named BorderPaneExample. 
// 2.	Run the application to see how the labels are organized in different sections.  lab11practice2

import javafx.application.Application;import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class lab11practice2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a BorderPane
        BorderPane borderPane = new BorderPane();
        
        // Set components for each section
        borderPane.setTop(new Label("Top Label"));        // Top section
        borderPane.setLeft(new Label("Left Label"));      // Left section
        borderPane.setRight(new Label("Right Label"));    // Right section
        borderPane.setCenter(new Label("Center Label"));  // Center section
        borderPane.setBottom(new Label("Bottom Label"));  // Bottom section
        
        // Create and set the Scene
        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BorderPane Example");
        primaryStage.show();  // Display the window
    }

    public static void main(String[] args) {
        launch(args);  // Launch the application
    }
}
