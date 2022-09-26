import java.util.Arrays;
import java.util.Objects;

public class Library {
    private Book[] books;
    private int index = 0;

    public Library(int i) {
        this.books = new Book[i];
    }

    public void addBook(Book book) {

        if (search(book) >= 0) {
            System.out.println("This book already added!");
            return;
        }
        if (books[books.length - 1] != null) this.grow();
        books[index] = book;
        index++;
    }

    public void viewAll() {
        //iDea советует foreach, но есть подозрения что могут быть ошибки когда
        //цикл будет обрабатывать null значения. В такой реализации я уверен.
        Arrays.stream(books).filter(Objects::nonNull).forEach(System.out::println);
    }

    private void grow() {
        // нужно ли тут this?
        this.books = Arrays.copyOf(this.books, this.books.length * 2);
    }

    private int search(Book book) {
        int index = -1;
        for (int i = 0; i < books.length; i++) {
            if (book.equals(books[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void bookInfo(Book book) {
        int i = search(book);
        System.out.println(i < 0 ? "This book not found!" : books[i]);
    }

    public void setYear(Book book, int year) {
        int i = search(book);
        if (i < 0) {
            System.out.println("This book not found!");
            return;
        }
        books[i].setYear(year);
    }
}
