// File: librarymanagement/LibrarySystem.java
package lab8Task1.librarymanagement;

import lab8Task1.library.Book;
import lab8Task1.library.FictionBook;
import lab8Task1.library.NonFictionBook;

public class LibrarySystem {
    public static void main(String[] args) {
        // Create instances of different types of books
        Book fictionBook = new FictionBook("The Great Gatsby");
        Book nonFictionBook = new NonFictionBook("Sapiens: A Brief History of Humankind");

        // Borrow and return books using the common Book interface
        fictionBook.borrow();
        fictionBook.returnBook();

        nonFictionBook.borrow();
        nonFictionBook.returnBook();
    }
}
