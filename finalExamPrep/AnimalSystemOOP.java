// ✅ ANIMAL SYSTEM USING OOP + JavaFX
// Covers: Abstract class (Animal), Interface (Pet), Inheritance (Dog, Cat)

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Interface
interface Pet {
    String play();
}

// Abstract Class
abstract class Animal {
    abstract String makeSound();
    public String getType() {
        return this.getClass().getSimpleName();
    }
}

// Subclass Dog
class Dog extends Animal implements Pet {
    @Override
    public String makeSound() {
        return "Bark! Bark!";
    }

    @Override
    public String play() {
        return "Dog plays fetch.";
    }
}

// Subclass Cat
class Cat extends Animal implements Pet {
    @Override
    public String makeSound() {
        return "Meow! Meow!";
    }

    @Override
    public String play() {
        return "Cat plays with yarn.";
    }
}

public class AnimalSystemOOP extends Application {
    @Override
    public void start(Stage stage) {
        Label output = new Label("Choose an animal to see its behavior:");
        Button dogBtn = new Button("Dog");
        Button catBtn = new Button("Cat");

        dogBtn.setOnAction(e -> {
            Animal dog = new Dog();
            output.setText(dog.getType() + ": " + dog.makeSound() + "\n" + ((Pet) dog).play());
        });

        catBtn.setOnAction(e -> {
            Animal cat = new Cat();
            output.setText(cat.getType() + ": " + cat.makeSound() + "\n" + ((Pet) cat).play());
        });

        VBox root = new VBox(10, output, dogBtn, catBtn);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Animal OOP System");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
