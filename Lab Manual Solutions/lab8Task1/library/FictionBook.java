package lab8Task1.library;


public class FictionBook implements Book {
    private String title;

    public FictionBook(String title) {
        this.title = title;
    }

    @Override
    public void borrow() {
        System.out.println("You have borrowed the fiction book: " + title);
    }

    @Override
    public void returnBook() {
        System.out.println("You have returned the fiction book: " + title);
    }
}
