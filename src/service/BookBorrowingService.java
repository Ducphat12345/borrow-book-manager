package service;

import main.Main;
import model.*;

import java.util.*;

public class BookBorrowingService {

    public void bookBorrowing() {
        if (Main.books.isEmpty() || Main.readers.isEmpty()) {
            System.out.println("Không có bản ghi nào!");
            return;
        }
        Reader reader;
        Book book;
        int quantityMajorBook;
        int quantityBook;
        int bookID;
        System.out.println("Nhập số lượng bạn đọc mượn sách:");
        try {
            int quantityReader = Integer.parseInt(Constants.scanner.nextLine());

            for (int i = 0; i < quantityReader; i++) {
                System.out.println("Nhập id bạn đọc thứ " + (i + 1) + " muốn mượn sách:");
                do {
                    int readerID = Integer.parseInt(Constants.scanner.nextLine());
                    reader = Reader.findByReaderID(readerID);
                    if (reader != null) {
                        break;
                    }
                    System.out.println("Không tìm thấy bạn đọc mang id " + readerID + ", nhập lại:");
                } while (true);

                System.out.println("Nhập số lượng đầu sách mà bạn đọc này muốn mượn:");
                do {
                    quantityMajorBook = Integer.parseInt(Constants.scanner.nextLine());
                    if (quantityMajorBook > 0 && quantityMajorBook <= 5) {
                        break;
                    }
                    System.out.println("Tối đa chỉ được mượn 5 đầu sách khác nhau, nhập lại:");
                } while (true);

                List<Book> books = new ArrayList<>(quantityMajorBook);
                int totalBook = 0;

                for (int j = 0; j < quantityMajorBook; j++) {
                    System.out.println("Nhập id đầu sách thứ " + (j + 1) + " mà bạn đọc này muốn mượn:");
                    do {
                        bookID = Integer.parseInt(Constants.scanner.nextLine());
                        book = Book.findByIdBookMajor(bookID);
                        if (book != null) {
                            break;
                        }
                        System.out.println("Không tìm thấy đầu sách mang id " + bookID + ", nhập lại:");
                    } while (true);

                    System.out.println("Nhập số lượng cuốn sách của đầu sách mang id " + bookID + " mà bạn đọc này muốn mượn:");
                    do {
                        quantityBook = Integer.parseInt(Constants.scanner.nextLine());
                        if (quantityBook > 0 && quantityBook <= 3) {
                            break;
                        }
                        System.out.println("Tối đa chỉ được mượn 3 cuốn sách khác nhau, nhập lại:");
                    } while (true);
                    books.add(book);
                    totalBook += quantityBook;
                }
                BookBorrowing bookBorrowing = new BookBorrowing(reader, books, totalBook);
                Main.bookBorrowings.add(bookBorrowing);
            }
            System.out.println("Danh sách các bạn đọc mượn sách là:");
            for (int i = 0; i < Main.bookBorrowings.size(); i++) {
                System.out.println(Main.bookBorrowings.get(i));
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Không đúng định dạng, nhập lại:");
        }
    }

    public void sortBookBorrowingByNameReader() {
        if (Main.bookBorrowings.isEmpty()) {
            System.out.println("Không có bản ghi nào!");
            return;
        }
        Main.bookBorrowings.sort(Comparator.comparing(reader -> reader.getReader().getFullName()));
        System.out.println("Danh sách bạn đọc theo tên là:");
        for (int i = 0; i < Main.bookBorrowings.size(); i++) {
            System.out.println(Main.bookBorrowings.get(i));
        }
    }

    public void sortBookBorrowingByAmountBook() {
        if (Main.bookBorrowings.isEmpty()) {
            System.out.println("Không có bản ghi nào!");
            return;
        }
        Main.bookBorrowings.sort((count1, count2) -> count1.getTotalBook() < count2.getTotalBook() ? 1 : -1);
        System.out.println("Danh sách các bạn đọc mượn sách(giảm dần) là:");
        for (int i = 0; i < Main.bookBorrowings.size(); i++) {
            System.out.println(Main.bookBorrowings.get(i));
        }
    }

    public void findBookBorrowingByNameReader() {
        if (Main.bookBorrowings.isEmpty()) {
            System.out.println("Không có bản ghi nào!");
            return;
        }
        System.out.println("Nhập tên bạn đọc muốn tìm kiếm:");
        do {
            try {
                String fullName = String.valueOf(Constants.scanner.nextLine());
                BookBorrowing bookBorrowing = BookBorrowing.findByReaderName(fullName);
                if (bookBorrowing != null) {
                    System.out.println("Tìm thấy bạn đọc là:");
                    System.out.println(bookBorrowing);
                    break;
                }
                System.out.println("Không tìm thấy bạn đọc mang tên " + fullName + ", nhập lại:");
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Không đúng định dạng, nhập lại:");
            }
        } while (true);
    }
}
