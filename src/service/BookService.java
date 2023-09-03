package service;

import main.Main;
import model.Book;
import model.Constants;

public class BookService {

    public static void addNewBook() {
        System.out.println("Nhập số lượng đầu sách mà bạn muốn thêm:");
        try {
            int amount = Integer.parseInt(Constants.scanner.nextLine());
            for (int i = 0; i < amount; i++) {
                System.out.println("Nhập thông tin đầu sách thứ " + (i + 1));
                Book book = new Book();
                book.inputInfo();
                Main.books.add(book);
                System.out.println("Thêm thành công!");
                Book.IDENTITY_ID++;
            }
            System.out.println("Danh sách các đầu sách là:");
            showListBook();
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Không đúng định dạng, nhập lại:");
        }
    }

    public static void showListBook() {
        for (int i = 0; i < Main.books.size(); i++) {
            System.out.println(Main.books.get(i));
        }
    }
}
