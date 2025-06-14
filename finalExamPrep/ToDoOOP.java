// =======================================================
//    TODO List App Using OOP (Inheritance + Interface)
// =======================================================

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



interface TaskHandler {
    void addTask(String task);
    void deleteTask(String task);
}

abstract class TaskManager {
    protected ListView<String> taskList = new ListView<>();

    public ListView<String> getTaskList() {
        return taskList;
    }
}

class TodoManager extends TaskManager implements TaskHandler {
    @Override
    public void addTask(String task) {
        if (!task.isEmpty()) taskList.getItems().add(task);
    }

    @Override
    public void deleteTask(String task) {
        taskList.getItems().remove(task);
    }
}

public class ToDoOOP extends Application {
    private TodoManager manager = new TodoManager();

    @Override
    public void start(Stage stage) {
        TextField input = new TextField();
        Button add = new Button("Add");
        Button del = new Button("Delete");

        add.setOnAction(e -> {
            manager.addTask(input.getText());
            input.clear();
        });

        del.setOnAction(e -> {
            String selected = manager.getTaskList().getSelectionModel().getSelectedItem();
            manager.deleteTask(selected);
        });

        VBox root = new VBox(10, input, add, del, manager.getTaskList());
        root.setPadding(new Insets(10));
        stage.setScene(new Scene(root, 300, 400));
        stage.setTitle("TODO List OOP");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

