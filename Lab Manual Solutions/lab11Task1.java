import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class lab11Task1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create the top section (Title)
        Label titleLabel = new Label("Business Dashboard");

        // Create the left section (ListView for KPIs)
        ListView<String> kpiListView = new ListView<>();
        kpiListView.getItems().addAll("Total Sales", "Active Users", "Customer Satisfaction");

        // Create the right section (PieChart for sales distribution)
        PieChart salesPieChart = new PieChart();
        PieChart.Data slice1 = new PieChart.Data("Product A", 40);
        PieChart.Data slice2 = new PieChart.Data("Product B", 30);
        PieChart.Data slice3 = new PieChart.Data("Product C", 20);
        PieChart.Data slice4 = new PieChart.Data("Product D", 10);
        
        salesPieChart.getData().addAll(slice1, slice2, slice3, slice4);

        // Create the bottom section (Footer)
        Label footerLabel = new Label("© 2024 Business Inc.");
        
        // Set up the BorderPane layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(titleLabel);
        borderPane.setLeft(kpiListView);
        borderPane.setRight(salesPieChart);
        borderPane.setBottom(footerLabel);  // Add footer to bottom section

        // Create a Scene and add the layout to it
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Business Dashboard");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
