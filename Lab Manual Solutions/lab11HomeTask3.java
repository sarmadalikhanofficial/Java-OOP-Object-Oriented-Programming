import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.*;

public class lab11HomeTask3 extends Application {

    private GridPane surveyGrid;
    private PieChart pieChart;
    private Map<String, ToggleGroup> questionToggleGroups = new LinkedHashMap<>();
    private Map<String, Integer> responseCountMap = new LinkedHashMap<>();
    private ObservableList<PieChart.Data> pieChartData = javafx.collections.FXCollections.observableArrayList();

    private final File csvFile = new File("survey_results.csv");

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        surveyGrid = new GridPane();
        surveyGrid.setPadding(new Insets(10));
        surveyGrid.setHgap(10);
        surveyGrid.setVgap(10);

        addSurveyQuestion("What is your favorite color?", "Red", "Blue", "Green", "Yellow");
        addSurveyQuestion("What is your favorite pet?", "Dog", "Cat", "Bird", "Fish");

        Button submitButton = new Button("Submit Survey");
        submitButton.setOnAction(e -> handleSubmit());

        VBox surveyBox = new VBox(10, surveyGrid, submitButton);
        surveyBox.setPadding(new Insets(10));

        pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Survey Results");

        root.setLeft(surveyBox);
        root.setCenter(pieChart);

        loadSurveyResultsFromCSV(); // load past results

        Scene scene = new Scene(root, 900, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Survey Application with Real-Time Results");
        primaryStage.show();
    }

    private void addSurveyQuestion(String question, String... options) {
        Label questionLabel = new Label(question);
        ToggleGroup group = new ToggleGroup();
        questionToggleGroups.put(question, group);

        int row = surveyGrid.getRowCount();
        surveyGrid.add(questionLabel, 0, row);

        for (int i = 0; i < options.length; i++) {
            RadioButton rb = new RadioButton(options[i]);
            rb.setToggleGroup(group);
            surveyGrid.add(rb, i + 1, row);
        }
    }

    private void handleSubmit() {
        List<String> selectedAnswers = new ArrayList<>();

        for (Map.Entry<String, ToggleGroup> entry : questionToggleGroups.entrySet()) {
            Toggle selected = entry.getValue().getSelectedToggle();
            if (selected != null) {
                RadioButton selectedRB = (RadioButton) selected;
                String answer = selectedRB.getText();
                selectedAnswers.add(answer);
                responseCountMap.put(answer, responseCountMap.getOrDefault(answer, 0) + 1);
            }
        }

        saveResponsesToCSV(selectedAnswers);
        updatePieChartData();
    }

    private void updatePieChartData() {
        pieChartData.clear();
        for (Map.Entry<String, Integer> entry : responseCountMap.entrySet()) {
            if (entry.getValue() > 0) {
                pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
            }
        }
    }

    private void saveResponsesToCSV(List<String> responses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
            writer.write(String.join(",", responses));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSurveyResultsFromCSV() {
        if (!csvFile.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] answers = line.split(",");
                for (String answer : answers) {
                    responseCountMap.put(answer, responseCountMap.getOrDefault(answer, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        updatePieChartData();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
