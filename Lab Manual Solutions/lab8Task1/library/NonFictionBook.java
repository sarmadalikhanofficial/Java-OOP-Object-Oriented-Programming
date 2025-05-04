package lab8Task1.library;

public class NonFictionBook implements Book {
    private String title;

    public NonFictionBook(String title) {
        this.title = title;
    }

    @Override
    public void borrow() {
        System.out.println("You have borrowed the non-fiction book: " + title);
    }

    @Override
    public void returnBook() {
        System.out.println("You have returned the non-fiction book: " + title);
    }
}
