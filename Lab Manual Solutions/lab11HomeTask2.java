import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class lab11HomeTask2 extends Application {

    private ObservableList<Book> bookList = FXCollections.observableArrayList();
    private ObservableList<Book> favoriteBooks = FXCollections.observableArrayList();
    private TilePane bookTilePane = new TilePane();
    private ListView<String> favoritesListView = new ListView<>();
    private Button viewFavoritesButton = new Button("View Favorites");
    
    private static final String FAVORITES_FILE = "favorites.txt";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library Catalog System");

        // Add books to the catalog
        bookList.add(new Book("Book 1", "Author 1", "Genre 1", "Short description of Book 1"));
        bookList.add(new Book("Book 2", "Author 2", "Genre 2", "Short description of Book 2"));
        bookList.add(new Book("Book 3", "Author 3", "Genre 3", "Short description of Book 3"));
        bookList.add(new Book("Book 4", "Author 4", "Genre 4", "Short description of Book 4"));

        // Create the main window layout
        VBox mainLayout = new VBox(10);
        bookTilePane.setHgap(10);
        bookTilePane.setVgap(10);

        // Create a button for each book
        for (Book book : bookList) {
            Button bookButton = new Button(book.getTitle());
            bookButton.setOnAction(e -> openBookDetailsWindow(book));
            bookTilePane.getChildren().add(bookButton);
        }

        // View Favorites Button
        viewFavoritesButton.setOnAction(e -> openFavoritesWindow(primaryStage));

        // Main layout
        mainLayout.getChildren().addAll(bookTilePane, viewFavoritesButton);

        // Create the scene for the main window
        Scene mainScene = new Scene(mainLayout, 500, 400);
        primaryStage.setScene(mainScene);
        primaryStage.show();

        // Load the favorites list from file
        loadFavorites();
    }

    private void openBookDetailsWindow(Book book) {
        // Create a new window for book details
        Stage bookDetailsStage = new Stage();
        bookDetailsStage.setTitle(book.getTitle() + " Details");

        // Layout for book details
        VBox detailsLayout = new VBox(10);
        Label titleLabel = new Label("Title: " + book.getTitle());
        Label authorLabel = new Label("Author: " + book.getAuthor());
        Label genreLabel = new Label("Genre: " + book.getGenre());
        Label descriptionLabel = new Label("Description: " + book.getDescription());
        Button favoriteButton = new Button("Mark as Favorite");

        favoriteButton.setOnAction(e -> markAsFavorite(book));

        detailsLayout.getChildren().addAll(titleLabel, authorLabel, genreLabel, descriptionLabel, favoriteButton);

        // Scene for book details
        Scene bookDetailsScene = new Scene(detailsLayout, 300, 200);
        bookDetailsStage.setScene(bookDetailsScene);
        bookDetailsStage.show();
    }

    private void markAsFavorite(Book book) {
        // Mark the book as a favorite and store it in the favorites list
        if (!favoriteBooks.contains(book)) {
            favoriteBooks.add(book);
            saveFavorites();
        }
    }

    private void openFavoritesWindow(Stage primaryStage) {
        // Create a new window to display the list of favorite books
        Stage favoritesStage = new Stage();
        favoritesStage.setTitle("Favorites");

        // Layout for the favorites list
        VBox favoritesLayout = new VBox(10);
        favoritesListView.setItems(FXCollections.observableArrayList(getFavoriteBookTitles()));
        favoritesLayout.getChildren().addAll(favoritesListView);

        // Scene for the favorites window
        Scene favoritesScene = new Scene(favoritesLayout, 300, 200);
        favoritesStage.setScene(favoritesScene);
        favoritesStage.show();
    }

    private List<String> getFavoriteBookTitles() {
        List<String> titles = new ArrayList<>();
        for (Book book : favoriteBooks) {
            titles.add(book.getTitle());
        }
        return titles;
    }

    private void saveFavorites() {
        // Save the favorites list to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FAVORITES_FILE))) {
            oos.writeObject(favoriteBooks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFavorites() {
        // Load the favorites list from a file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FAVORITES_FILE))) {
            favoriteBooks.clear();
            favoriteBooks.addAll((List<Book>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Book class to represent the books in the catalog
    public static class Book implements Serializable {
        private String title;
        private String author;
        private String genre;
        private String description;

        public Book(String title, String author, String genre, String description) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getGenre() {
            return genre;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Book book = (Book) obj;
            return title.equals(book.title);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title);
        }
    }
}



// A:\Iqra University\Java-OOP-Object-Oriented-Programming\Lab Manual Solutions>javac --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls lab11HomeTask2.java

// A:\Iqra University\Java-OOP-Object-Oriented-Programming\Lab Manual Solutions>java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls lab11HomeTask2