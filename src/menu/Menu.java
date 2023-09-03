package menu;

public class Menu {

    public static void menu() {
        System.out.println("------------------------------MENU---------------------------------");
        System.out.println("1. Nhập danh sách đầu sách mới. In ra danh sách các đầu sách đã có.");
        System.out.println("2. Nhập danh sách bạn đọc mới. In ra danh sách bạn đọc đã có.");
        System.out.println("3. Quản lý mượn sách cho bạn đọc.");
        System.out.println("4. Sắp xếp danh sách quản lý mượn sách.");
        System.out.println("5. Tìm kiếm và hiển thị danh sách mượn sách theo tên bạn đọc.");
        System.out.println("6. Kết thúc chương trình.");
        System.out.println("----------------------Mời bạn chọn chương trình--------------------");
    }

    public static void typeReader() {
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giáo viên");
    }

    public static void majorBook() {
        System.out.println("1. Khoa học tự nhiên");
        System.out.println("2. Văn học - Nghệ thuật");
        System.out.println("3. Điện tử viễn thông");
        System.out.println("4. Công nghệ thông tin");
    }

    public static void menuSort() {
        System.out.println("1. Theo tên bạn đọc");
        System.out.println("2. Theo Số lượng cuốn sách được mượn (giảm dần)");
    }
}
