package model;

import main.Main;
import menu.Menu;

public class Book implements InputData {
    public static int IDENTITY_ID = 10000;
    private int bookID;
    private String bookName;
    private String author;
    private String bookMajor;
    private int publishing_year;

    public Book() {
    }

    public Book(String bookName, String author, String bookMajor, int publishing_year) {
        this.bookName = bookName;
        this.author = author;
        this.bookMajor = bookMajor;
        this.publishing_year = publishing_year;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookMajor() {
        return bookMajor;
    }

    public void setBookMajor(String bookMajor) {
        this.bookMajor = bookMajor;
    }

    public int getPublishing_year() {
        return publishing_year;
    }

    public void setPublishing_year(int publishing_year) {
        this.publishing_year = publishing_year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", bookMajor='" + bookMajor + '\'' +
                ", publishing_year=" + publishing_year +
                '}';
    }

    @Override
    public void inputInfo() {
        this.bookID = Book.IDENTITY_ID;

        do {
            System.out.println("Nhập tên cuốn sách:");
            this.bookName = Constants.scanner.nextLine();
            if (ValidateData.checkNameBook(this.bookName)) {
                break;
            }
            System.out.println("Tên cuốn sách không hợp lệ và không được để trống!");
        } while (true);

        do {
            System.out.println("Nhập tác giả của cuốn sách:");
            this.author = Constants.scanner.nextLine();
            if (ValidateData.checkAuthorBook(this.author)) {
                break;
            }
            System.out.println("Tên tác giả không hợp lệ và không được để trống!");
        } while (true);

        do {
            System.out.println("Chọn chuyên ngành cuốn sách:");
            Menu.majorBook();
            try {
                int choose = Integer.parseInt(Constants.scanner.nextLine());
                switch (choose) {
                    case 1:
                        this.bookMajor = Constants.NATURAL_SCIENCES;
                        break;
                    case 2:
                        this.bookMajor = Constants.LITERATURE_ART;
                        break;
                    case 3:
                        this.bookMajor = Constants.ELECTRONICS_TELECOMMUNICATION;
                        break;
                    case 4:
                        this.bookMajor = Constants.INFORMATION_TECHNOLOGY;
                        break;
                    default:
                        System.out.println("Không tồn tại chuyên ngành sách mà bạn chọn! Chọn lại:");
                        break;
                }
                if (ValidateData.checkMajorBook(this.bookMajor)) {
                    break;
                }
                System.out.println("Phải chọn chuyên ngành cuốn sách!");
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Không đúng định dạng!");
            }
        } while (true);

        do {
            System.out.println("Nhập năm xuất bản cuốn sách:");
            try {
                this.publishing_year = Integer.parseInt(Constants.scanner.nextLine());
                if (ValidateData.checkPublishingYearBook(this.publishing_year)) {
                    break;
                }
                System.out.println("Năm xuất bản phải nhỏ hơn năm hiện tại!");
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Không đúng định dạng!");
            }
        } while (true);
    }

    public static Book findByIdBookMajor(int id) {
        for (int i = 0; i < Main.books.size(); i++) {
            if (id == Main.books.get(i).getBookID()) {
                return Main.books.get(i);
            }
        }
        return null;
    }
}
