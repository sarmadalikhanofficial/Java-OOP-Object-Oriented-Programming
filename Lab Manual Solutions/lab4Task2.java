// BOOK CLASS
class Book {
    // Data members
    String title;
    String author;
    String ISBN;
    int yearPublished;
    int copiesAvailable;

    // Constructor with title and author
    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.ISBN = "N/A";
        this.yearPublished = 0;
        this.copiesAvailable = 0;
    }

    // Constructor with title, author, and ISBN
    Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = 0;
        this.copiesAvailable = 0;
    }

    // Constructor with all attributes
    Book(String title, String author, String ISBN, int yearPublished, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
        this.copiesAvailable = copiesAvailable;
    }

    // Method to display book information
    void displayBookInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Copies Available: " + copiesAvailable);
        System.out.println("------------------------------");
    }

    // Method to update number of copies
    void updateCopies(int newCopies) {
        this.copiesAvailable = newCopies;
        System.out.println("Updated copies available for '" + title + "': " + copiesAvailable);
    }
}

public class lab4Task2 {
    public static void main(String[] args) {
        // Book with only title and author
        Book book1 = new Book("Atomic Habits", "James Clear");

        // Book with title, author, and ISBN
        Book book2 = new Book("Clean Code", "Robert C. Martin", "9780132350884");

        // Book with all attributes
        Book book3 = new Book("Java: The Complete Reference", "Herbert Schildt", "9781260440232", 2019, 10);

        // Display all books
        book1.displayBookInfo();
        book2.displayBookInfo();
        book3.displayBookInfo();

        // Update copies of book3
        book3.updateCopies(15);
    }
}
