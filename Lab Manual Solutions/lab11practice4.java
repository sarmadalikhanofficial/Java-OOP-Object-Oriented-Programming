// 4. Pie Chart Example 
// Create a simple application to display a pie chart using JavaFX. 

// Steps: 
// 1.	Implement the above code in a class named PieChartExample. 
// 2.	Run the application to see how the pie chart displays data. 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class lab11practice4 extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pie Chart Example");

        PieChart pieChart = new PieChart();
        PieChart.Data slice1 = new PieChart.Data("Category A", 30);
        PieChart.Data slice2 = new PieChart.Data("Category B", 70);

        pieChart.getData().addAll(slice1, slice2);

        VBox vbox = new VBox(pieChart);
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
