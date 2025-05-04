import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class lab13Task3 extends Application {

    private TextField nameField, quantityField, priceField, searchField;
    private TextArea outputArea;
    private TextArea descriptionArea;

    @Override
    public void start(Stage stage) {
        // Input Fields
        nameField = new TextField();
        quantityField = new TextField();
        priceField = new TextField();
        descriptionArea = new TextArea();
        descriptionArea.setPrefRowCount(2);

        Button addButton = new Button("Add Product");
        Button viewButton = new Button("View All Products");

        // Search Section
        searchField = new TextField();
        Button searchButton = new Button("Search Product");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);

        addButton.setOnAction(e -> saveProduct());
        viewButton.setOnAction(e -> displayInventory());
        searchButton.setOnAction(e -> searchProduct());

        // Layout
        GridPane form = new GridPane();
        form.setPadding(new Insets(15));
        form.setVgap(10);
        form.setHgap(10);

        form.add(new Label("Product Name:"), 0, 0); form.add(nameField, 1, 0);
        form.add(new Label("Quantity:"), 0, 1); form.add(quantityField, 1, 1);
        form.add(new Label("Price:"), 0, 2); form.add(priceField, 1, 2);
        form.add(new Label("Description:"), 0, 3); form.add(descriptionArea, 1, 3);
        form.add(new HBox(10, addButton, viewButton), 1, 4);
        form.add(new Label("Search Product by Name:"), 0, 5); form.add(searchField, 1, 5);
        form.add(searchButton, 1, 6);
        form.add(outputArea, 0, 7, 2, 1);

        Scene scene = new Scene(form, 600, 500);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    private void saveProduct() {
        String name = nameField.getText().trim();
        String quantity = quantityField.getText().trim();
        String price = priceField.getText().trim();
        String description = descriptionArea.getText().trim();

        if (name.isEmpty() || quantity.isEmpty() || price.isEmpty()) {
            showAlert("Please fill all required fields.");
            return;
        }

        try {
            Integer.parseInt(quantity);
            Double.parseDouble(price);
        } catch (NumberFormatException e) {
            showAlert("Quantity must be a number. Price must be a valid number.");
            return;
        }

        String record = name + "," + quantity + "," + price + "," + description;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.txt", true))) {
            writer.write(record);
            writer.newLine();
            showAlert("Product added successfully!");
            clearForm();
        } catch (IOException e) {
            showAlert("Error writing to file.");
        }
    }

    private void displayInventory() {
        StringBuilder result = new StringBuilder();

        try (Scanner scanner = new Scanner(new File("inventory.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",", -1);
                if (parts.length >= 4) {
                    result.append("Name: ").append(parts[0])
                          .append(", Quantity: ").append(parts[1])
                          .append(", Price: ").append(parts[2])
                          .append(", Description: ").append(parts[3])
                          .append("\n");
                }
            }

            outputArea.setText(result.toString());

        } catch (FileNotFoundException e) {
            showAlert("No inventory file found.");
        }
    }

    private void searchProduct() {
        String searchTerm = searchField.getText().trim().toLowerCase();
        if (searchTerm.isEmpty()) {
            showAlert("Please enter a product name to search.");
            return;
        }

        StringBuilder result = new StringBuilder();
        boolean found = false;

        try (Scanner scanner = new Scanner(new File("inventory.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",", -1);
                if (parts.length >= 4 && parts[0].toLowerCase().contains(searchTerm)) {
                    found = true;
                    result.append("Name: ").append(parts[0])
                          .append(", Quantity: ").append(parts[1])
                          .append(", Price: ").append(parts[2])
                          .append(", Description: ").append(parts[3])
                          .append("\n");
                }
            }

            if (found) {
                outputArea.setText(result.toString());
            } else {
                outputArea.setText("Product not found.");
            }

        } catch (FileNotFoundException e) {
            showAlert("No inventory file found.");
        }
    }

    private void clearForm() {
        nameField.clear();
        quantityField.clear();
        priceField.clear();
        descriptionArea.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
