package main;

import menu.Menu;
import model.*;
import service.BookBorrowingService;
import service.BookService;
import service.ReaderService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static BookService bookService = new BookService();

    static ReaderService readerService = new ReaderService();

    static BookBorrowingService bookBorrowingService = new BookBorrowingService();

    public static List<Book> books = new ArrayList<>();

    public static List<Reader> readers = new ArrayList<>();

    public static List<BookBorrowing> bookBorrowings = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            Menu.menu();
            try {
                int choose = Integer.parseInt(Constants.scanner.nextLine());
                switch (choose) {
                    case 1:
                        addNewBook();
                        break;
                    case 2:
                        addNewReader();
                        break;
                    case 3:
                        bookBorrowing();
                        break;
                    case 4:
                        Menu.menuSort();
                        try {
                            int sort = Integer.parseInt(Constants.scanner.nextLine());
                            if (sort == 1) {
                                sortBookBorrowingByNameReader();
                            } else if (sort == 2) {
                                sortBookBorrowingByAmountBook();
                            }
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("Không đúng định dạng!");
                        }
                        break;
                    case 5:
                        findBookBorrowingManagement();
                        break;
                    case 6:
                        System.out.println("Kết thúc chương trình!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Không có chương trình bạn chọn, Nhập lại:");
                        break;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Không đúng định dạng!");
            }
        }
    }

    public static void addNewBook() {
        bookService.addNewBook();
    }

    public static void addNewReader() {
        readerService.addNewReader();
    }

    public static void bookBorrowing() {
        bookBorrowingService.bookBorrowing();
    }

    public static void sortBookBorrowingByNameReader() {
        bookBorrowingService.sortBookBorrowingByNameReader();
    }

    public static void sortBookBorrowingByAmountBook() {
        bookBorrowingService.sortBookBorrowingByAmountBook();
    }

    public static void findBookBorrowingManagement() {
        bookBorrowingService.findBookBorrowingByNameReader();
    }
}
