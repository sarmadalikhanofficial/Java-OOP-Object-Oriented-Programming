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
import java.util.*;
import java.util.stream.Collectors;

public class lab13HomeTask3 extends Application {
    private final String FILE_NAME = "multi_store_inventory.csv";
    private TableView<Product> tableView;
    private ObservableList<Product> products = FXCollections.observableArrayList();
    private TextArea reportArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Multi-Store Inventory Management System");

        // Form Fields
        TextField nameField = new TextField();
        TextField quantityField = new TextField();
        TextField priceField = new TextField();
        TextField storeField = new TextField();
        TextField supplierField = new TextField();
        TextField contactField = new TextField();
        TextArea descriptionField = new TextArea();
        Button addButton = new Button("Add Product");

        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Product Name:"), 0, 0); form.add(nameField, 1, 0);
        form.add(new Label("Quantity:"), 0, 1); form.add(quantityField, 1, 1);
        form.add(new Label("Price:"), 0, 2); form.add(priceField, 1, 2);
        form.add(new Label("Store Location:"), 0, 3); form.add(storeField, 1, 3);
        form.add(new Label("Supplier:"), 0, 4); form.add(supplierField, 1, 4);
        form.add(new Label("Supplier Contact:"), 0, 5); form.add(contactField, 1, 5);
        form.add(new Label("Description:"), 0, 6); form.add(descriptionField, 1, 6);
        form.add(addButton, 1, 7);

        // Table
        tableView = new TableView<>();
        tableView.setItems(products);
        tableView.getColumns().addAll(
                createColumn("Product Name", "name"),
                createColumn("Quantity", "quantity"),
                createColumn("Price", "price"),
                createColumn("Store", "store"),
                createColumn("Supplier", "supplier")
        );

        Button loadBtn = new Button("Load Inventory");
        Button reportBtn = new Button("Generate Report");
        reportArea = new TextArea();
        reportArea.setPrefRowCount(10);

        HBox actions = new HBox(10, loadBtn, reportBtn);
        actions.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10, form, tableView, actions, reportArea);
        layout.setPadding(new Insets(15));

        addButton.setOnAction(e -> addProduct(nameField, quantityField, priceField, storeField, supplierField, contactField, descriptionField));
        loadBtn.setOnAction(e -> loadProducts());
        reportBtn.setOnAction(e -> generateReport());

        primaryStage.setScene(new Scene(layout, 900, 700));
        primaryStage.show();
    }

    private TableColumn<Product, String> createColumn(String title, String property) {
        TableColumn<Product, String> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property));
        return col;
    }

    private void addProduct(TextField name, TextField qty, TextField price, TextField store, TextField supplier, TextField contact, TextArea desc) {
        try {
            String line = String.join(",",
                    name.getText(),
                    qty.getText(),
                    price.getText(),
                    store.getText(),
                    supplier.getText(),
                    contact.getText(),
                    desc.getText()
            );

            try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME, true))) {
                out.println(line);
            }

            name.clear(); qty.clear(); price.clear(); store.clear(); supplier.clear(); contact.clear(); desc.clear();
            loadProducts();
        } catch (IOException ex) {
            showError("Error writing to file.");
        }
    }

    private void loadProducts() {
        products.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 7) {
                    Product p = new Product(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            Double.parseDouble(parts[2]),
                            parts[3], parts[4], parts[5], parts[6]);
                    products.add(p);
                }
            }
        } catch (IOException e) {
            showError("Error reading file.");
        }
    }

    private void generateReport() {
        Map<String, Double> storeValueMap = new HashMap<>();
        for (Product p : products) {
            storeValueMap.merge(p.getStore(), p.getQuantity() * p.getPrice(), Double::sum);
        }

        StringBuilder report = new StringBuilder("INVENTORY VALUE REPORT:\n");
        for (Map.Entry<String, Double> entry : storeValueMap.entrySet()) {
            report.append("Store: ").append(entry.getKey())
                  .append(" - Total Inventory Value: Rs ").append(entry.getValue()).append("\n");
        }

        reportArea.setText(report.toString());
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }

    public static class Product {
        private final String name, store, supplier, contact, description;
        private final int quantity;
        private final double price;

        public Product(String name, int quantity, double price, String store, String supplier, String contact, String description) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.store = store;
            this.supplier = supplier;
            this.contact = contact;
            this.description = description;
        }

        public String getName() { return name; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }
        public String getStore() { return store; }
        public String getSupplier() { return supplier; }
    }
}
