import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class lab10HomeTask2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a TextField for entering a task
        TextField taskField = new TextField();
        taskField.setPromptText("Enter your task here");

        // Create a ListView to display tasks
        ListView<String> taskList = new ListView<>();

        // Create a Button to add tasks to the list
        Button addTaskButton = new Button("Add Task");

        // Create a Button to remove selected tasks
        Button removeTaskButton = new Button("Remove Selected Task");

        // Add event handler to add tasks
        addTaskButton.setOnAction(e -> {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                taskList.getItems().add(task);
                taskField.clear(); // Clear the text field after adding the task
            }
        });

        // Add event handler to remove selected tasks with confirmation
        removeTaskButton.setOnAction(e -> {
            String selectedTask = taskList.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                // Confirmation dialog
                Alert confirmation = new Alert(AlertType.CONFIRMATION);
                confirmation.setTitle("Confirm Deletion");
                confirmation.setHeaderText("Are you sure you want to delete this task?");
                confirmation.setContentText("Task: " + selectedTask);
                confirmation.showAndWait().ifPresent(response -> {
                    if (response == javafx.scene.control.ButtonType.OK) {
                        taskList.getItems().remove(selectedTask); // Remove the selected task
                    }
                });
            }
        });

        // Arrange the components in a VBox layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(taskField, addTaskButton, taskList, removeTaskButton);

        // Set up the scene
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setTitle("To-Do List Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
