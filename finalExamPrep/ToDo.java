// =======================================================
//       Basic TODO List App (Without OOP Concepts)
// =======================================================
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;


public class ToDoList extends Application {
    private ListView<String> taskList;

    @Override
    public void start(Stage primaryStage) {
        taskList = new ListView<>();
        TextField taskInput = new TextField();
        Button addBtn = new Button("Add Task");
        Button delBtn = new Button("Delete Selected");

        addBtn.setOnAction(e -> {
            String task = taskInput.getText();
            if (!task.isEmpty()) taskList.getItems().add(task);
            taskInput.clear();
        });

        delBtn.setOnAction(e -> {
            String selected = taskList.getSelectionModel().getSelectedItem();
            if (selected != null) taskList.getItems().remove(selected);
        });

        VBox layout = new VBox(10, taskInput, addBtn, delBtn, taskList);
        layout.setPadding(new Insets(10));
        primaryStage.setScene(new Scene(layout, 300, 400));
        primaryStage.setTitle("TODO List");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

