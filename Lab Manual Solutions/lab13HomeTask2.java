import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class lab13HomeTask2 extends Application {
    private final String FILE_NAME = "feedback_records.txt";
    private ObservableList<Feedback> feedbackList = FXCollections.observableArrayList();
    private TableView<Feedback> tableView = new TableView<>();
    private Label summaryLabel = new Label();
    private ComboBox<Integer> filterRating = new ComboBox<>();
    private PieChart ratingChart = new PieChart();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Input Form
        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        ComboBox<Integer> ratingBox = new ComboBox<>();
        ratingBox.getItems().addAll(1, 2, 3, 4, 5);
        ratingBox.setPromptText("Rating (1-5)");

        TextArea commentArea = new TextArea();
        commentArea.setPromptText("Feedback Comment");

        Button submitButton = new Button("Submit Feedback");
        submitButton.setOnAction(e -> handleSubmit(nameField, emailField, ratingBox, commentArea));

        HBox inputRow1 = new HBox(10, nameField, emailField, ratingBox);
        VBox form = new VBox(10, inputRow1, commentArea, submitButton);
        form.setPadding(new Insets(10));

        // TableView Setup
        TableColumn<Feedback, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Feedback, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Feedback, Integer> ratingCol = new TableColumn<>("Rating");
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));

        TableColumn<Feedback, String> commentCol = new TableColumn<>("Comment");
        commentCol.setCellValueFactory(new PropertyValueFactory<>("comment"));
        commentCol.setPrefWidth(300);

        tableView.getColumns().addAll(nameCol, emailCol, ratingCol, commentCol);
        tableView.setItems(feedbackList);

        // Filter and Chart
        filterRating.getItems().addAll(1, 2, 3, 4, 5);
        filterRating.setPromptText("Filter by Rating");
        filterRating.setOnAction(e -> filterFeedback());

        VBox display = new VBox(10, new Label("Feedback Summary:"), summaryLabel, new Label("Rating Distribution:"), ratingChart);
        VBox tableSection = new VBox(10, new Label("All Feedback:"), filterRating, tableView, display);
        tableSection.setPadding(new Insets(10));

        HBox root = new HBox(20, form, tableSection);

        Scene scene = new Scene(root, 1000, 600);
        stage.setTitle("Participant Feedback Collection System");
        stage.setScene(scene);
        stage.show();

        loadFeedbackFromFile();
        updateSummary();
        updateChart();
    }

    private void handleSubmit(TextField name, TextField email, ComboBox<Integer> rating, TextArea comment) {
        String nameVal = name.getText().trim();
        String emailVal = email.getText().trim();
        Integer ratingVal = rating.getValue();
        String commentVal = comment.getText().trim();

        if (nameVal.isEmpty() || emailVal.isEmpty() || ratingVal == null || commentVal.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        Feedback fb = new Feedback(nameVal, emailVal, ratingVal, commentVal);
        feedbackList.add(fb);
        writeToFile(fb);

        name.clear();
        email.clear();
        rating.setValue(null);
        comment.clear();

        updateSummary();
        updateChart();
    }

    private void writeToFile(Feedback fb) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(fb.toCSV());
            writer.newLine();
        } catch (IOException e) {
            showAlert("File Error", "Unable to write to file.");
        }
    }

    private void loadFeedbackFromFile() {
        feedbackList.clear();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Feedback fb = new Feedback(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
                    feedbackList.add(fb);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found or unreadable.");
        }
    }

    private void updateSummary() {
        int count = feedbackList.size();
        double avg = feedbackList.stream().mapToInt(Feedback::getRating).average().orElse(0);
        summaryLabel.setText("Total Feedbacks: " + count + "\nAverage Rating: " + String.format("%.2f", avg));
    }

    private void updateChart() {
        Map<Integer, Long> counts = feedbackList.stream().collect(Collectors.groupingBy(Feedback::getRating, Collectors.counting()));
        ratingChart.getData().clear();
        for (int i = 1; i <= 5; i++) {
            long count = counts.getOrDefault(i, 0L);
            ratingChart.getData().add(new PieChart.Data("Rating " + i, count));
        }
    }

    private void filterFeedback() {
        Integer selected = filterRating.getValue();
        if (selected == null) {
            tableView.setItems(feedbackList);
        } else {
            ObservableList<Feedback> filtered = feedbackList.filtered(fb -> fb.getRating() == selected);
            tableView.setItems(filtered);
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static class Feedback {
        private String name, email, comment;
        private int rating;

        public Feedback(String name, String email, int rating, String comment) {
            this.name = name;
            this.email = email;
            this.rating = rating;
            this.comment = comment;
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
        public int getRating() { return rating; }
        public String getComment() { return comment; }

        public String toCSV() {
            return name + "," + email + "," + rating + "," + comment;
        }
    }
}
