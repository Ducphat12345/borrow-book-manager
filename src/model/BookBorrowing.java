package model;

import main.Main;

import java.util.List;

public class BookBorrowing {
    private Reader reader;
    private List<Book> books;
    private int totalBook;

    public BookBorrowing() {
    }

    public BookBorrowing(Reader reader, List<Book> books, int totalBook) {
        this.reader = reader;
        this.books = books;
        this.totalBook = totalBook;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "reader=" + reader +
                ", books=" + books +
                ", totalBook=" + totalBook +
                '}';
    }

    public static BookBorrowing findByReaderName(String fullName) {
        for (int i = 0; i < Main.bookBorrowings.size(); i++) {
            if (fullName.equalsIgnoreCase(Main.bookBorrowings.get(i).getReader().getFullName())) {
                return Main.bookBorrowings.get(i);
            }
        }
        return null;
    }
}
