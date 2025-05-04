import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.LocalDate;

public class lab12practice extends Application {

    String user = "admin";
    String pw = "password";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Form");

        // --- BorderPane Layout for Login ---
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 50, 50, 50));

        // --- Header HBox ---
        HBox hb = new HBox();
        hb.setPadding(new Insets(20, 20, 20, 30));
        Text headerText = new Text("Login Form");
        headerText.setFont(Font.font("Verdana", 30));
        headerText.setEffect(new DropShadow(5, 5, 5, Color.GRAY));
        hb.getChildren().add(headerText);

        // --- Login Form Grid ---
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setEffect(new Reflection());

        Label lblUserName = new Label("Username");
        TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Login");
        Label lblMessage = new Label();

        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 2, 1);
        gridPane.add(lblMessage, 1, 2);

        bp.setTop(hb);
        bp.setCenter(gridPane);

        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // --- Login Button Action ---
        btnLogin.setOnAction(event -> {
            String checkUser = txtUserName.getText().trim();
            String checkPw = pf.getText().trim();

            if (checkUser.isEmpty() || checkPw.isEmpty()) {
                lblMessage.setText("Username or password cannot be empty.");
                lblMessage.setTextFill(Color.RED);
            } else if (checkUser.equals(user) && checkPw.equals(pw)) {
                lblMessage.setText("Congratulations! Redirecting...");
                lblMessage.setTextFill(Color.GREEN);
                new NextPageWindow(); // show next page
                primaryStage.close(); // close login
            } else {
                lblMessage.setText("Incorrect username or password.");
                lblMessage.setTextFill(Color.RED);
            }
            txtUserName.clear();
            pf.clear();
        });
    }

    // --- Next Page Class (Add User) ---
    public class NextPageWindow {
        public NextPageWindow() {
            Stage window = new Stage();
            window.setTitle("Add User");
            window.setWidth(450);
            window.setHeight(450);
            window.setResizable(false);

            GridPane layout = new GridPane();
            layout.setPadding(new Insets(20));
            layout.setVgap(10);
            layout.setHgap(10);

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
            ObservableList<String> items = FXCollections.observableArrayList("PhD", "Master", "Graduate", "Intermediate", "Matric");
            ListView<String> eduList = new ListView<>(items);
            eduList.setPrefHeight(70);

            Label loc = new Label("Location");
            ComboBox<String> locList = new ComboBox<>();
            locList.getItems().addAll("Karachi", "Islamabad", "Multan", "Lahore", "Peshawar");

            Label dob = new Label("DOB");
            DatePicker date = new DatePicker(LocalDate.now());

            Button btnSignup = new Button("Add User");
            Button btnClear = new Button("Clear");

            layout.add(name, 0, 1);
            layout.add(ntext, 1, 1);
            layout.add(email, 0, 2);
            layout.add(etext, 1, 2);
            layout.add(gender, 0, 3);
            layout.add(rmale, 1, 3);
            layout.add(rfemale, 1, 4);
            layout.add(edu, 0, 5);
            layout.add(eduList, 1, 5);
            layout.add(loc, 0, 6);
            layout.add(locList, 1, 6);
            layout.add(dob, 0, 7);
            layout.add(date, 1, 7);
            layout.add(btnSignup, 1, 8);
            layout.add(btnClear, 1, 9);

            GridPane.setMargin(rfemale, new Insets(0, 0, 0, 80));
            GridPane.setMargin(btnClear, new Insets(0, 0, 0, 80));

            // Button actions
            btnSignup.setOnAction(e -> {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("User added successfully!");
                alert.show();
            });

            btnClear.setOnAction(e -> {
                ntext.clear();
                etext.clear();
                group.selectToggle(null);
                eduList.getSelectionModel().clearSelection();
                locList.getSelectionModel().clearSelection();
                date.setValue(LocalDate.now());
            });

            // Add Menu
            BorderPane root = new BorderPane();
            MenuBar menuBar = new MenuBar();
            Menu fileMenu = new Menu("File");
            MenuItem newItem = new MenuItem("New");
            MenuItem saveItem = new MenuItem("Save");
            MenuItem exitItem = new MenuItem("Exit");
            exitItem.setOnAction(ev -> Platform.exit());
            fileMenu.getItems().addAll(newItem, saveItem, new SeparatorMenuItem(), exitItem);
            menuBar.getMenus().addAll(fileMenu);
            root.setTop(menuBar);
            root.setCenter(layout);

            Scene scene = new Scene(root);
            window.setScene(scene);
            window.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}



// A:\Iqra University\Java-OOP-Object-Oriented-Programming\Lab Manual Solutions>java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml lab12practice.java

// A:\Iqra University\Java-OOP-Object-Oriented-Programming\Lab Manual Solutions>java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml lab12practice.java

