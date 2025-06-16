import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class LIBFX extends Application{
	
	@Override
	public void start (Stage stage){

        TextField nameField = new TextField();
		TextField authorField = new TextField();
		TextField isbnField = new TextField();
		
		nameField.setPromptText("Book Name");
		authorField.setPromptText("Author Name");
		isbnField.setPromptText("ISBN Number");
	
		ListView<String> bookList = new ListView<>();
		Button addBtn = new Button ("Add Book");
		Button delBtn = new Button ("Delete Book");
		Label viewLabel = new Label("View Books");

		
		addBtn.setOnAction(e-> {
			String name = nameField.getText();
			String author = authorField.getText();
			String isbn = isbnField.getText();
			
			if (!name.isEmpty() && !author.isEmpty() && !isbn.isEmpty()){
                String book = name + " by " + author + " (ISBN: " + isbn + ")";
				bookList.getItems().add(book);
				
				nameField.clear();
				authorField.clear();
				isbnField.clear();
			}
		});
		
		delBtn.setOnAction(e-> {
			String selected = bookList.getSelectionModel().getSelectedItem();
			bookList.getItems().remove(selected);
		});
		
		VBox root = new VBox(10, nameField, authorField, isbnField, addBtn, delBtn, viewLabel, bookList);
		root.setPadding(new javafx.geometry.Insets(10));
		
		stage.setScene(new Scene(root, 400, 450));
        stage.setTitle("Library App");
        stage.show();
        
        
		
	}

	 public static void main(String[] args) {
	        launch(args);
	    }
}
