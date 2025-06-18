import java.util.*;

// Base class for Person
class Person {
    private String id;
    private String name;
    private String contactInfo;

    public Person(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}

// Updated Book class to include setters for updating book details
class Book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private boolean isBorrowed;

    public Book(String id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isBorrowed = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}

// Transaction class
class Transaction {
    private String memberId;
    private String bookId;
    private Date borrowDate;
    private Date returnDate;

    public Transaction(String memberId, String bookId, Date borrowDate, Date returnDate) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}

//  Librarian class to include update book functionality and view borrowing history
class Librarian extends Person {
    public Librarian(String id, String name, String contactInfo) {
        super(id, name, contactInfo);
    }

    public void addBook(Library library, Book book) {
        if (library.addBook(book)) {
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Cannot add book. Maximum limit reached.");
        }
    }

    public void removeBook(List<Book> books, String bookId) {
        books.removeIf(book -> book.getId().equals(bookId) && !book.isBorrowed());
    }

    public void updateBook(List<Book> books, String bookId, String newTitle, String newAuthor, String newGenre) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setGenre(newGenre);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void registerMember(List<Member> members, Member member) {
        members.add(member);
    }

    public void removeMember(List<Member> members, String memberId) {
        members.removeIf(member -> member.getId().equals(memberId));
    }

    public void viewBorrowingHistory(Library library, String memberId) {
        List<Transaction> history = library.getMemberHistory(memberId);
        if (history.isEmpty()) {
            System.out.println("No borrowing history found for this member.");
        } else {
            for (Transaction transaction : history) {
                System.out.println("Book ID: " + transaction.getBookId() + ", Borrow Date: " + transaction.getBorrowDate() + ", Return Date: " + transaction.getReturnDate());
            }
        }
    }
}

// Member class
class Member extends Person {
    private List<Book> borrowedBooks;

    public Member(String id, String name, String contactInfo) {
        super(id, name, contactInfo);
        this.borrowedBooks = new ArrayList<>();
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() < 5 && !book.isBorrowed()) {
            borrowedBooks.add(book);
            book.setBorrowed(true);
        }
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setBorrowed(false);
    }
}

// Updated Library class to include borrowing history and book limit
class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;
    private static final int MAX_BOOKS = 100;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public boolean addBook(Book book) {
        if (books.size() < MAX_BOOKS) {
            books.add(book);
            return true;
        }
        return false;
    }

    public List<Book> searchBooks(String query, String type) {
        List<Book> result = new ArrayList<>();
        query = query.toLowerCase(); // Convert query to lowercase for case-insensitive matching
        for (Book book : books) {
            if (type.equalsIgnoreCase("all")) {
                if (book.getTitle().toLowerCase().contains(query) ||
                    book.getAuthor().toLowerCase().contains(query) ||
                    book.getGenre().toLowerCase().contains(query)) {
                    result.add(book);
                }
            } else if (type.equalsIgnoreCase("title") && book.getTitle().toLowerCase().contains(query)) {
                result.add(book);
            } else if (type.equalsIgnoreCase("author") && book.getAuthor().toLowerCase().contains(query)) {
                result.add(book);
            } else if (type.equalsIgnoreCase("genre") && book.getGenre().toLowerCase().contains(query)) {
                result.add(book);
            }
        }
        return result;
    }

    public void recordTransaction(String memberId, String bookId, Date borrowDate, Date returnDate) {
        transactions.add(new Transaction(memberId, bookId, borrowDate, returnDate));
    }

    public List<Transaction> getMemberHistory(String memberId) {
        List<Transaction> history = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getMemberId().equals(memberId)) {
                history.add(transaction);
            }
        }
        return history;
    }
}

// Main class with menu-driven interface
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Librarian librarian = new Librarian("L1", "Admin", "admin@library.com");

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("Are you a Librarian or a Member?");
            System.out.println("1. Librarian");
            System.out.println("2. Member");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int userType = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (userType == 3) {
                System.out.println("Exiting system. Goodbye!");
                scanner.close();
                return;
            }

            if (userType == 1) {
                while (true) {
                    System.out.println("\nLibrarian Menu");
                    System.out.println("1. Add Book");
                    System.out.println("2. Remove Book");
                    System.out.println("3. Update Book");
                    System.out.println("4. Register Member");
                    System.out.println("5. Remove Member");
                    System.out.println("6. Search Books");
                    System.out.println("7. View Borrowing History");
                    System.out.println("8. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter Book ID: ");
                            String bookId = scanner.nextLine();
                            System.out.print("Enter Title: ");
                            String title = scanner.nextLine();
                            System.out.print("Enter Author: ");
                            String author = scanner.nextLine();
                            System.out.print("Enter Genre: ");
                            String genre = scanner.nextLine();
                            librarian.addBook(library, new Book(bookId, title, author, genre));
                            break;
                        case 2:
                            System.out.print("Enter Book ID to remove: ");
                            String removeBookId = scanner.nextLine();
                            librarian.removeBook(library.getBooks(), removeBookId);
                            System.out.println("Book removed successfully.");
                            break;
                        case 3:
                            System.out.print("Enter Book ID to update: ");
                            String updateBookId = scanner.nextLine();
                            System.out.print("Enter new Title: ");
                            String newTitle = scanner.nextLine();
                            System.out.print("Enter new Author: ");
                            String newAuthor = scanner.nextLine();
                            System.out.print("Enter new Genre: ");
                            String newGenre = scanner.nextLine();
                            librarian.updateBook(library.getBooks(), updateBookId, newTitle, newAuthor, newGenre);
                            break;
                        case 4:
                            System.out.print("Enter Member ID: ");
                            String memberId = scanner.nextLine();
                            System.out.print("Enter Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Contact Info: ");
                            String contactInfo = scanner.nextLine();
                            librarian.registerMember(library.getMembers(), new Member(memberId, name, contactInfo));
                            System.out.println("Member registered successfully.");
                            break;
                        case 5:
                            System.out.print("Enter Member ID to remove: ");
                            String removeMemberId = scanner.nextLine();
                            librarian.removeMember(library.getMembers(), removeMemberId);
                            System.out.println("Member removed successfully.");
                            break;
                        case 6:
                            System.out.print("Search by (title/author/genre): ");
                            String query = scanner.nextLine().trim();
                            if (query.isEmpty()) {
                                System.out.println("Search query cannot be empty.");
                                break;
                            }
                            List<Book> results = library.searchBooks(query, "all");
                            if (results.isEmpty()) {
                                System.out.println("No books found.");
                            } else {
                                for (Book book : results) {
                                    System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Genre: " + book.getGenre());
                                }
                            }
                            break;
                        case 7:
                            System.out.print("Enter Member ID to view borrowing history: ");
                            String historyMemberId = scanner.nextLine();
                            librarian.viewBorrowingHistory(library, historyMemberId);
                            break;
                        case 8:
                            System.out.println("Returning to main menu.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }

                    if (choice == 8) break;
                }
            } else if (userType == 2) {
                while (true) {
                    System.out.println("\nMember Menu");
                    System.out.println("1. Search Books");
                    System.out.println("2. Borrow Book");
                    System.out.println("3. Return Book");
                    System.out.println("4. View Borrowed Books");
                    System.out.println("5. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Search by (title/author/genre): ");
                            String query = scanner.nextLine().trim();
                            List<Book> results = library.searchBooks(query, "all");
                            if (results.isEmpty()) {
                                System.out.println("No books found.");
                            } else {
                                for (Book book : results) {
                                    System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Genre: " + book.getGenre());
                                }
                            }
                            break;
                        case 2:
                            System.out.print("Enter your Member ID: ");
                            String memberId = scanner.nextLine();
                            Member borrowingMember = library.getMembers().stream().filter(m -> m.getId().equals(memberId)).findFirst().orElse(null);
                            if (borrowingMember == null) {
                                System.out.println("Invalid Member ID.");
                                break;
                            }

                            System.out.print("Enter Book ID to borrow: ");
                            String borrowBookId = scanner.nextLine();
                            Book bookToBorrow = library.getBooks().stream().filter(b -> b.getId().equals(borrowBookId) && !b.isBorrowed()).findFirst().orElse(null);
                            if (bookToBorrow == null) {
                                System.out.println("Book is not available.");
                                break;
                            }

                            borrowingMember.borrowBook(bookToBorrow);
                            library.recordTransaction(memberId, borrowBookId, new Date(), null);
                            System.out.println("Book borrowed successfully.");
                            break;
                        case 3:
                            System.out.print("Enter your Member ID: ");
                            String returnMemberId = scanner.nextLine();
                            System.out.print("Enter Book ID to return: ");
                            String returnBookId = scanner.nextLine();
                            Member returningMember = library.getMembers().stream().filter(m -> m.getId().equals(returnMemberId)).findFirst().orElse(null);
                            Book bookToReturn = library.getBooks().stream().filter(b -> b.getId().equals(returnBookId) && b.isBorrowed()).findFirst().orElse(null);
                            if (returningMember != null && bookToReturn != null) {
                                returningMember.returnBook(bookToReturn);
                                library.recordTransaction(returnMemberId, returnBookId, null, new Date());
                                System.out.println("Book returned successfully.");
                            } else {
                                System.out.println("Invalid Member ID or Book is not borrowed.");
                            }
                            break;
                        case 4:
                            System.out.print("Enter your Member ID: ");
                            String viewMemberId = scanner.nextLine();
                            Member viewingMember = library.getMembers().stream().filter(m -> m.getId().equals(viewMemberId)).findFirst().orElse(null);
                            if (viewingMember != null) {
                                List<Book> borrowedBooks = viewingMember.getBorrowedBooks();
                                if (borrowedBooks.isEmpty()) {
                                    System.out.println("No borrowed books.");
                                } else {
                                    for (Book book : borrowedBooks) {
                                        System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Genre: " + book.getGenre());
                                    }
                                }
                            } else {
                                System.out.println("Invalid Member ID.");
                            }
                            break;
                        case 5:
                            System.out.println("Returning to main menu.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                    if (choice == 5) break;
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
