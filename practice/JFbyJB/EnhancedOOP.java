import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Book {
    String name, author, isbn;
    Book(String n, String a, String i) { name = n; author = a; isbn = i; }
    public String toString() { return name + " by " + author + " (ISBN: " + isbn + ")"; }
}

interface BookOps {
    void addBook(Book b);
    void removeBook(Book b);
}

abstract class BookHandler implements BookOps {
    public abstract ListView<Book> getBookList();
}

class Library extends BookHandler {
    private ListView<Book> list = new ListView<>();
    public void addBook(Book b) { list.getItems().add(b); }
    public void removeBook(Book b) { list.getItems().remove(b); }
    public ListView<Book> getBookList() { return list; }
}

public class EnhancedOOP extends Application {
    Library lib = new Library();

    public void start(Stage stage) {
        TextField name = new TextField(), author = new TextField(), isbn = new TextField();
        name.setPromptText("Book Name");
        author.setPromptText("Author");
        isbn.setPromptText("ISBN");

        Button add = new Button("Add"), del = new Button("Delete");

        add.setOnAction(e -> {
            if (!name.getText().isEmpty() && !author.getText().isEmpty() && !isbn.getText().isEmpty()) {
                lib.addBook(new Book(name.getText(), author.getText(), isbn.getText()));
                name.clear(); author.clear(); isbn.clear();
            }
        });

        del.setOnAction(e -> lib.removeBook(lib.getBookList().getSelectionModel().getSelectedItem()));

        VBox root = new VBox(10, name, author, isbn, add, del, lib.getBookList());
        root.setPadding(new javafx.geometry.Insets(10));
        stage.setScene(new Scene(root, 400, 450));
        stage.setTitle("Mini OOP Library");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
