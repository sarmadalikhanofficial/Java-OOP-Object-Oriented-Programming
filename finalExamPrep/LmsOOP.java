// =======================================================
//      Mini Library Management System Using OOP
// =======================================================

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

abstract class BookHandler {
    abstract void addBook(String name);
    abstract void removeBook(String name);
    public abstract ListView<String> getBookList();
}

interface Logger {
    default void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}

class LibraryManager extends BookHandler implements Logger {
    private ListView<String> books = new ListView<>();

    @Override
    public void addBook(String name) {
        if (!name.isEmpty()) books.getItems().add(name);
        log("Book added: " + name);
    }

    @Override
    public void removeBook(String name) {
        books.getItems().remove(name);
        log("Book removed: " + name);
    }

    @Override
    public ListView<String> getBookList() {
        return books;
    }
}

public class LmsOOP extends Application {
    private LibraryManager libManager = new LibraryManager();

    @Override
    public void start(Stage stage) {
        TextField input = new TextField();
        Button add = new Button("Add Book");
        Button del = new Button("Delete Book");

        add.setOnAction(e -> {
            libManager.addBook(input.getText());
            input.clear();
        });

        del.setOnAction(e -> {
            String selected = libManager.getBookList().getSelectionModel().getSelectedItem();
            libManager.removeBook(selected);
        });

        VBox root = new VBox(10, input, add, del, libManager.getBookList());
        root.setPadding(new Insets(10));
        stage.setScene(new Scene(root, 350, 400));
        stage.setTitle("Library Management System");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
