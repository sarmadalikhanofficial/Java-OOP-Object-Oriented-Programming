# Java-OOP (Object-Oriented Programming)

This repository contains **Java OOP (Object-Oriented Programming)** concepts, including classwork, assignments, and practice programs. As the **Class Representative (CR)**, I will ensure that all relevant codes and materials are maintained here for easy access by classmates.

## 📌 About
- Covers **core OOP principles** like **Encapsulation, Inheritance, Polymorphism, and Abstraction**.
- Includes **class lectures, assignments, and extra practice programs**.
- Helps students understand Java OOP with **real-world examples**.

## 🚀 Getting Started
### Prerequisites
Ensure you have the following installed:
- **Java Development Kit (JDK)** (version 8 or above recommended)
- **Java Runtime Environment (JRE)**
- **IDE (Eclipse, IntelliJ IDEA, or VS Code)**
- **JavaFX SDK**
- **Git (for cloning this repository)**

### Installation
1. **Clone the repository**:
   ```bash
   git clone https://github.com/sarmadalikhanofficial/Java-OOP-Object-Oriented-Programming
   cd Java-OOP-Object-Oriented-Programming
   ```
2. **Ensure JDK is installed**:
   ```bash
   java -version
   ```
3. **Compile and Run a Java Program**:
   ```bash
   javac filename.java
   java filename
   ```

## 📂 Directory Structure
```
Java-OOP-Object-Oriented-Programming/
│-- .vscode/ # VS Code workspace settings
│-- Lab Manual Solutions/ # Final Lab Manual Solutions
│-- Lab_Manual/     # Initial lab manual files
│-- classwork/      # Programs from lectures
│-- assignments/    # Submitted assignment codes
│-- examprep/ # Programs for exam preparation
│-- practice/       # Additional practice problems
│-- README.md       # Project documentation
│-- .gitignore # Git ignore rules
```

## ⚡ How to Contribute
1. Fork the repository.
2. Make your changes in a separate branch.
3. Submit a **Pull Request** with proper comments.

## 📜 License
This repository is maintained for educational purposes. Feel free to use the code for learning but give credit if shared.

---

## Java & Eclipse Installation Guide

## Step 1: Install Java JDK
Download & install Java JDK from the link:
🔗 [Java JDK 23](https://download.oracle.com/java/23/latest/jdk-23_windows-x64_bin.exe)

## Step 2: Install Java JRE
Get Java JRE from the link:
🔗 [Java JRE](https://javadl.oracle.com/webapps/download/AutoDL?BundleId=251656_7ed26d28139143f38c58992680c214a5)

## Step 3: Install Eclipse Neon
Download Eclipse Neon from the link below:
🔗 [Eclipse Neon](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/neon/3/eclipse-java-neon-3-win32-x86_64.zip)

## 🎨 JavaFX Setup & Execution Guide

To run JavaFX-based programs, follow these steps:

### 🔽 Step 1: Download JavaFX SDK

Download the JavaFX SDK from the official site:

🔗 [Download JavaFX SDK](https://gluonhq.com/products/javafx/)

> 💡 **Important:** After downloading, extract the JavaFX SDK to the following location on your system:  
> `C:\javafx-sdk-24.0.1\`

### ⚙️ Step 2: Compile JavaFX Programs from Terminal

Use the following command to compile a JavaFX `.java` file via terminal:

```bash
javac --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml filedirectory\fileName.java

```
### ⚙️ Step 3: Run JavaFX Program from Terminal

Use the following command to run your compiled JavaFX `.class`:
```bash
java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml fileName
```

# JavaFX Setup in Eclipse - Complete Guide

## Step 2: Configure Eclipse for JavaFX
1. Open Eclipse
2. Go to Window → Preferences
3. Navigate to Java → Build Path → User Libraries
4. Click the "New" button
5. Enter a name like "JavaFX" and click "OK"
6. Select the newly created "JavaFX" library in the list
7. Click "Add External JARs"
8. Navigate to your JavaFX SDK lib folder (e.g., C:\javafx-sdk-24.0.1\lib)
9. Select all JAR files:
   - javafx.base.jar
   - javafx.controls.jar
   - javafx.fxml.jar
   - javafx.graphics.jar
   - javafx.media.jar
   - javafx.swing.jar
   - javafx.web.jar
10. Click "Open" to add the JARs
  
### For New Project:
1. File → New → Java Project
2. Give your project a name
3. Right-click on the project → Properties
4. Go to Java Build Path → Libraries
5. Click "Add Library" → User Library → JavaFX → Finish
6. Click "Apply" and "Close"

### For Existing Project:
1. Right-click on your existing project
2. Select Properties
3. Go to Java Build Path → Libraries
4. Click "Add Library" → User Library → JavaFX → Finish
5. Click "Apply" and "Close"

## Step 5: Create a Sample JavaFX Program
```java
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class JAVAFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
```

## Troubleshooting Common Issues
1. If "Add External JARs" is grayed out:
   - Make sure you've created the User Library first
   - Select the library in the list before trying to add JARs

2. If you see red errors:
   - Verify all JAR files are properly added
   - Make sure you're using Java 11 or later
   - Clean and rebuild your project

3. If the program doesn't run:
   - Verify all required modules are added
   - Make sure your main class extends Application


## Important Notes
- In **Eclipse IDE**, your **project name** and **package name** must be the same.
- If you are copying code from **GitHub**, ensure that the **class name** matches exactly.
- Make sure you're in the correct **working directory** (i.e., the one containing Lab Manual Solutions) in the terminal.
- If your file uses packages, use dot . notation (e.g., package.name.ClassName) when running.

Follow these steps carefully to avoid any issues. 🚀

📢 **For any queries, feel free to reach out!** Let's make learning Java OOP easier together! 🚀

# Library Management System - Presentation Slides

## Slide 1: Introduction
- Title: Library Management System
- Overview of the project
- Key features: Book management, Member management, Transaction tracking
- Built using Java OOP principles

## Slide 2: OOP Pillars Overview
- Encapsulation: Private fields with public getters/setters
- Inheritance: Person class as base class for Librarian and Member
- Polymorphism: Different behaviors for Librarian and Member classes
- Abstraction: Abstract concepts like Person, Book, and Transaction

## Slide 3: Person Class (Base Class)
- Base class for all users in the system
- Implements Encapsulation:
  - Private fields: id, name, contactInfo
  - Public getters for accessing data
- Used as a foundation for Librarian and Member classes
- Demonstrates Inheritance principle

## Slide 4: Book Class
- Represents a book in the library
- Implements Encapsulation:
  - Private fields: id, title, author, genre, isBorrowed
  - Public getters and setters
- Tracks book status (borrowed/available)
- Core entity in the system

## Slide 5: Transaction Class
- Records book borrowing and returning
- Implements Encapsulation:
  - Private fields: memberId, bookId, borrowDate, returnDate
  - Public getters for accessing transaction data
- Maintains history of all book transactions
- Demonstrates data abstraction

## Slide 6: Librarian Class
- Extends Person class (Inheritance)
- Implements Polymorphism:
  - Specialized methods for library management
  - Different behavior from Member class
- Key responsibilities:
  - Add/remove/update books
  - Register/remove members
  - View borrowing history

## Slide 7: Member Class
- Extends Person class (Inheritance)
- Implements Polymorphism:
  - Specialized methods for book borrowing
  - Different behavior from Librarian class
- Key features:
  - Borrow and return books
  - Track borrowed books
  - Limited to 5 books at a time

## Slide 8: Library Class
- Core system class
- Implements Encapsulation:
  - Private collections for books, members, transactions
  - Public methods for system operations
- Key functionalities:
  - Book management
  - Member management
  - Transaction recording
  - Search functionality

## Slide 9: Main System Features
- User Interface:
  - Separate menus for Librarian and Member
  - Interactive command-line interface
- Key Operations:
  - Book search by title/author/genre
  - Book borrowing and returning
  - Member registration and management
  - Transaction history tracking

## Slide 10: OOP Principles in Action
- Encapsulation:
  - All classes use private fields with public accessors
  - Data hiding and controlled access
- Inheritance:
  - Person class as parent for Librarian and Member
  - Code reuse and hierarchy
- Polymorphism:
  - Different behaviors for Librarian and Member
  - Same interface, different implementations
- Abstraction:
  - Abstract concepts like Person, Book, Transaction
  - Simplified complex system representation


