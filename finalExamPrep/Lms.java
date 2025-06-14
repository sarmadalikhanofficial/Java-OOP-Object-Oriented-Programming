// =======================================================
//      Mini Library Management System without OOP
// =======================================================

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lms extends Application {
    private ListView<String> bookList = new ListView<>();

    @Override
    public void start(Stage stage) {
        TextField input = new TextField();
        Button addBtn = new Button("Add Book");
        Button delBtn = new Button("Delete Book");

        addBtn.setOnAction(e -> {
            String book = input.getText();
            if (!book.isEmpty()) {
                bookList.getItems().add(book);
                input.clear();
            }
        });

        delBtn.setOnAction(e -> {
            String selected = bookList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                bookList.getItems().remove(selected);
            }
        });

        VBox layout = new VBox(10, input, addBtn, delBtn, bookList);
        layout.setPadding(new Insets(10));
        stage.setScene(new Scene(layout, 320, 400));
        stage.setTitle("Mini Library System (No OOP)");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
