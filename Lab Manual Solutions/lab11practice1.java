// 1. FlowPane Example 
// Create a simple application using FlowPane to arrange buttons horizontally. 
// Steps: 
// 1.	Create a JavaFX project in your IDE. 
// 2.	Implement the above code in a class named FlowPaneExample. 
// 3.	Run the application to observe how the buttons are arranged. 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class lab11practice1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FlowPane Example");

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(button1, button2, button3);

        Scene scene = new Scene(flowPane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
