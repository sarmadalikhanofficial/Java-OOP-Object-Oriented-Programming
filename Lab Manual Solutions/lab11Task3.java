import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

public class lab11Task3 extends Application {

    private Map<Integer, String> correctAnswers = new HashMap<>();
    private Map<Integer, String> userAnswers = new HashMap<>();
    private VBox root = new VBox(20);
    private GridPane quizGrid = new GridPane();
    private int totalQuestions = 3;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Educational Quiz Application");

        quizGrid.setPadding(new Insets(20));
        quizGrid.setHgap(10);
        quizGrid.setVgap(15);
        quizGrid.setAlignment(Pos.CENTER);

        // Sample Questions
        String[][] questions = {
            {"What is the capital of France?", "Paris", "London", "Berlin", "Rome"},
            {"2 + 2 equals?", "3", "4", "5", "6"},
            {"Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Venus"}
        };

        // Set correct answers
        correctAnswers.put(0, "Paris");
        correctAnswers.put(1, "4");
        correctAnswers.put(2, "Mars");

        for (int i = 0; i < questions.length; i++) {
            Text questionText = new Text(questions[i][0]);
            quizGrid.add(questionText, 0, i);

            HBox optionButtons = new HBox(10);
            optionButtons.setAlignment(Pos.CENTER_LEFT);

            for (int j = 1; j <= 4; j++) {
                String option = questions[i][j];
                Button btn = new Button(option);
                int questionIndex = i;
                btn.setOnAction(e -> {
                    userAnswers.put(questionIndex, option);
                    // Disable all buttons for this question
                    optionButtons.getChildren().forEach(b -> b.setDisable(true));
                    btn.setStyle("-fx-background-color: lightgreen;");
                });
                optionButtons.getChildren().add(btn);
            }

            quizGrid.add(optionButtons, 1, i);
        }

        Button submitButton = new Button("Submit Answers");
        submitButton.setOnAction(e -> showResultChart());

        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(quizGrid, submitButton);

        Scene scene = new Scene(root, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showResultChart() {
        int correct = 0;
        int incorrect = 0;

        for (int i = 0; i < totalQuestions; i++) {
            String correctAns = correctAnswers.get(i);
            String userAns = userAnswers.get(i);
            if (correctAns.equals(userAns)) {
                correct++;
            } else {
                incorrect++;
            }
        }

        // Clear existing content
        root.getChildren().clear();

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        xAxis.setLabel("Answer Type");
        yAxis.setLabel("Count");
        barChart.setTitle("Quiz Performance");

        XYChart.Series<String, Number> data = new XYChart.Series<>();
        data.setName("Your Score");
        data.getData().add(new XYChart.Data<>("Correct", correct));
        data.getData().add(new XYChart.Data<>("Incorrect", incorrect));

        barChart.getData().add(data);
        barChart.setLegendVisible(false);

        root.getChildren().add(barChart);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


// A:\Iqra University\Java-OOP-Object-Oriented-Programming\Lab Manual Solutions>java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls lab11Task3.java

// A:\Iqra University\Java-OOP-Object-Oriented-Programming\Lab Manual Solutions>java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls lab11Task3.java