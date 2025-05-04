// lab5HomeTask3.java

class Book {
    private String title;
    private String author;
    private int copiesAvailable;

    // Constructor
    public Book(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Get book information
    public String getBookInfo() {
        return "Title: " + title + ", Author: " + author + ", Copies Available: " + copiesAvailable;
    }

    // Add copies
    public void addCopies(int newCopies) {
        copiesAvailable += newCopies;
    }

    // Borrow a book
    public boolean borrowBook() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
            return true;
        }
        return false;
    }

    // Getter for title (used in searching)
    public String getTitle() {
        return title;
    }

    // Getter for copies
    public int getCopiesAvailable() {
        return copiesAvailable;
    }
}

class Library {
    private Book[] books;
    private int count;

    // Constructor (max 100 books for simplicity)
    public Library() {
        books = new Book[100];
        count = 0;
    }

    // Add a new book
    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Find a book by title
    public Book findBookByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Borrow a book from library
    public void borrowBookFromLibrary(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            if (book.borrowBook()) {
                System.out.println("Successfully borrowed: " + title);
            } else {
                System.out.println("Sorry, '" + title + "' is out of stock.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    // Total books (sum of all available copies)
    public int totalBooks() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += books[i].getCopiesAvailable();
        }
        return total;
    }
}

public class lab5HomeTask3 {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        library.addBook(new Book("Java Programming", "John Doe", 3));
        library.addBook(new Book("Python Basics", "Jane Smith", 2));
        library.addBook(new Book("C++ Fundamentals", "Alex Ray", 1));

        // Borrowing books
        library.borrowBookFromLibrary("Java Programming");
        library.borrowBookFromLibrary("C++ Fundamentals");
        library.borrowBookFromLibrary("C++ Fundamentals"); // out of stock

        // Total available books
        System.out.println("Total books available: " + library.totalBooks());

        // Find and print book info
        Book foundBook = library.findBookByTitle("Python Basics");
        if (foundBook != null) {
            System.out.println("Book Found: " + foundBook.getBookInfo());
        } else {
            System.out.println("Book not found.");
        }
    }
}
