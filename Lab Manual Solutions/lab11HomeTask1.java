import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;
import java.lang.classfile.Label;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

public class lab11HomeTask1 extends Application {

    private static final String LAST_DIRECTORY_KEY = "lastDirectory";
    private static final String SEARCH_KEY = "searchQuery";
    private static final String TOTAL_FILES_KEY = "totalFiles";
    private static final String TOTAL_SIZE_KEY = "totalSize";

    private TableView<File> fileTable;
    private TreeView<String> directoryTree;
    private TextArea previewPane;
    private TextField searchField;
    private Label footerLabel;

    private File currentDirectory;

    public static void main(String[] args) {
        launch(args);
    }

    @@SuppressWarnings("unchecked")
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Top: Title and search bar
        Label titleLabel = new Label("File Management System");
        searchField = new TextField();
        searchField.setPromptText("Search files...");
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filterFiles(newValue));

        // Layout for top section
        BorderPane topSection = new BorderPane();
        topSection.setLeft(titleLabel);
        topSection.setCenter(searchField);
        root.setTop(topSection);

        // Left: Directory Tree View
        directoryTree = new TreeView<>();
        directoryTree.setRoot(createDirectoryTree(new File("C:/"))); // Example starting directory

        directoryTree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> loadFiles(newValue));

        // Layout for left section
        root.setLeft(directoryTree);

        // Center: File Details Table
        fileTable = new TableView<>();
        TableColumn<File, String> nameColumn = new TableColumn<>("File Name");
        nameColumn.setCellValueFactory(file -> new SimpleStringProperty(file.getValue().getName()));

        TableColumn<File, Long> sizeColumn = new TableColumn<>("Size");
        sizeColumn.setCellValueFactory(file -> new SimpleLongProperty(file.getValue().length()).asObject());

        TableColumn<File, String> modifiedColumn = new TableColumn<>("Last Modified");
        modifiedColumn.setCellValueFactory(file -> new SimpleStringProperty(file.getValue().lastModified() + ""));

        fileTable.getColumns().addAll(nameColumn, sizeColumn, modifiedColumn);
        root.setCenter(fileTable);

        // Right: File Preview Pane
        previewPane = new TextArea();
        previewPane.setEditable(false);
        root.setRight(previewPane);

        // Bottom: Footer showing file count and size
        footerLabel = new Label("Total Files: 0 | Total Size: 0 bytes");
        root.setBottom(footerLabel);

        // Set the scene
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("File Management System");
        primaryStage.show();

        // Load last directory and search state if available
        loadState();
    }

    // Load files from selected directory
    private void loadFiles(TreeItem<String> directoryItem) {
        currentDirectory = new File(directoryItem.getValue());
        if (currentDirectory.isDirectory()) {
            File[] files = currentDirectory.listFiles();
            if (files != null) {
                ObservableList<File> fileList = FXCollections.observableArrayList(files);
                fileTable.setItems(fileList);
            }
        }
    }

    // Filter files based on search query
    private void filterFiles(String query) {
        ObservableList<File> filteredFiles = FXCollections.observableArrayList();
        for (File file : fileTable.getItems()) {
            if (file.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredFiles.add(file);
            }
        }
        fileTable.setItems(filteredFiles);
    }

    // Create directory tree starting from a root folder
    private TreeItem<String> createDirectoryTree(File rootFolder) {
        TreeItem<String> rootItem = new TreeItem<>(rootFolder.getAbsolutePath());
        rootItem.setExpanded(true);
        File[] directories = rootFolder.listFiles(File::isDirectory);
        if (directories != null) {
            for (File dir : directories) {
                rootItem.getChildren().add(createDirectoryTree(dir));
            }
        }
        return rootItem;
    }

    // Save the last directory and search query to the system properties
    private void saveState() {
        if (currentDirectory != null) {
            System.setProperty(LAST_DIRECTORY_KEY, currentDirectory.getAbsolutePath());
        }
        if (searchField != null) {
            System.setProperty(SEARCH_KEY, searchField.getText());
        }
    }

    // Load the saved directory and search query state
    private void loadState() {
        String lastDirectory = System.getProperty(LAST_DIRECTORY_KEY);
        if (lastDirectory != null) {
            currentDirectory = new File(lastDirectory);
            if (currentDirectory.exists() && currentDirectory.isDirectory()) {
                loadFiles(new TreeItem<>(currentDirectory.getAbsolutePath()));
            }
        }

        String searchQuery = System.getProperty(SEARCH_KEY);
        if (searchQuery != null) {
            searchField.setText(searchQuery);
            filterFiles(searchQuery);
        }
    }

    // Close the application and save state
    @Override
    public void stop() {
        saveState();
    }

}
