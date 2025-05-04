import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class lab11Task2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Load the image from the same directory
        Image image = new Image("file:syrex.png");

        // Create 3 ImageViews using the same image
        ImageView img1 = new ImageView(image);
        ImageView img2 = new ImageView(image);
        ImageView img3 = new ImageView(image);

        // Optional: Set image size and maintain aspect ratio
        double width = 150;
        img1.setFitWidth(width);
        img1.setPreserveRatio(true);
        img2.setFitWidth(width);
        img2.setPreserveRatio(true);
        img3.setFitWidth(width);
        img3.setPreserveRatio(true);

        // Add them in a horizontal layout
        HBox root = new HBox(20); // 20 px spacing between images
        root.getChildren().addAll(img1, img2, img3);

        // Set the scene and show the stage
        Scene scene = new Scene(root, 520, 200);
        primaryStage.setTitle("Syrex Image x3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


// Navigate to the directory:
// cd "A:\Iqra University\Java-OOP-Object-Oriented-Programming\Lab Manual Solutions\lab11Task2"

// Then compile:
// javac --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls lab11Task2.java

// Then run:
// java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls lab11Task2