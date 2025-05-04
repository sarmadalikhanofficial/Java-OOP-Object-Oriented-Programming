package lab13practice.managmentSystem;

// Code for Signup Page: 
// This section contains the JavaFX implementation for the signup interface, allowing users to enter their information and store it in a file. 
// package lab13practice.managmentSystem; 

import java.io.IOException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Signup extends Application {

    Stage window;
    Scene scene;
    Connection con = new Connection();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Signup Screen");
        window.setHeight(600);
        window.setWidth(400);
        window.setResizable(false);
        addComponents();
        window.setScene(scene);
        window.show();
    }

    private void addComponents() {
        Label name = new Label("Name");
        TextField ntext = new TextField();

        Label email = new Label("Email");
        TextField etext = new TextField();

        Label gender = new Label("Gender");
        ToggleGroup group = new ToggleGroup();
        RadioButton rmale = new RadioButton("Male");
        RadioButton rfemale = new RadioButton("Female");
        rmale.setToggleGroup(group);
        rfemale.setToggleGroup(group);

        Label edu = new Label("Education");
        ObservableList<String> items = FXCollections.observableArrayList(
                "Phd", "Master", "Graduate", "Intermediate", "Matric");
        ListView<String> eduList = new ListView<>(items);

        Label loc = new Label("Location");
        ComboBox<String> locList = new ComboBox<>();
        locList.getItems().addAll("Karachi", "Islamabad", "Multan", "Lahore",
                "Peshawar");

        Label dob = new Label("DOB");
        DatePicker date = new DatePicker();
        date.setValue(LocalDate.now());

        Button btnsignup = new Button("Sign up");
        Button btnclear = new Button("Clear");

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(20));
        layout.setVgap(10);
        layout.add(name, 0, 1);
        layout.add(ntext, 1, 1);
        layout.add(email, 0, 2);
        layout.add(etext, 1, 2);
        layout.add(gender, 0, 3);
        layout.add(rmale, 1, 3);
        layout.add(rfemale, 1, 3);
        layout.setMargin(rfemale, new Insets(0, 0, 0, 80));
        layout.add(edu, 0, 4);
        layout.add(eduList, 1, 4);
        layout.add(loc, 0, 5);
        layout.add(locList, 1, 5);
        layout.add(dob, 0, 6);
        layout.add(date, 1, 6);
        layout.add(btnsignup, 1, 7);
        layout.add(btnclear, 1, 7);
        layout.setMargin(btnclear, new Insets(0, 0, 0, 80));

        btnsignup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String record = "";
                String rgender = "";

                record += ntext.getText() + ", ";
                record += etext.getText() + ", ";

                if (rmale.isSelected())
                    rgender = "male";
                else
                    rgender = "female";
                record += rgender + ", ";
                record += eduList.getSelectionModel().getSelectedItem()
                        + ", ";
                record += locList.getSelectionModel().getSelectedItem() +
                        ", ";
                record += date.getValue() + ", ";

                try {
                    con.WriteToFile(record);
                    System.out.println("done");
                } catch (IOException e) {
                    System.out.println("error");
                    e.printStackTrace();
                }
            }
        });

        scene = new Scene(layout);
    }
}




// A:\Iqra University\Java-OOP-Object-Oriented-Programming\Lab Manual Solutions>javac --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml lab13practice\managmentSystem\Signup.java

// A:\Iqra University\Java-OOP-Object-Oriented-Programming\Lab Manual Solutions>java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml 
// lab13practice\managmentSystem\Signup.java