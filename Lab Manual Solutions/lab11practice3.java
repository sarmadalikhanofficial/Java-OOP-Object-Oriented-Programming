// 3.	GridPane Example 
// Create an application using GridPane to arrange buttons in a grid layout. 
// Steps: 
// 1.	Implement the above code in a class named GridPaneExample. 
// 2.	Run the application to see how the buttons are organized in a grid. 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class lab11practice3 extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GridPane Example");

        // Create buttons
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");

        // Create GridPane layout
        GridPane gridPane = new GridPane();

        // Add buttons to specific positions in the grid
        gridPane.add(button1, 0, 0); // column 0, row 0
        gridPane.add(button2, 1, 0); // column 1, row 0
        gridPane.add(button3, 0, 1); // column 0, row 1
        gridPane.add(button4, 1, 1); // column 1, row 1

        // Create and set the Scene
        Scene scene = new Scene(gridPane, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show(); // Display the window
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}
