package model;

import main.Main;
import menu.Menu;

public class Reader extends Person {
    private int id;
    private String typeReader;

    public Reader() {
    }

    public Reader(String fullName, String address, String phoneNumber, int id, String typeReader) {
        super(fullName, address, phoneNumber);
        this.id = id;
        this.typeReader = typeReader;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeReader() {
        return typeReader;
    }

    public void setTypeReader(String typeReader) {
        this.typeReader = typeReader;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", " + super.toString() +
                ", typeReader=" + typeReader +
                "}";
    }

    @Override
    public void inputInfo() {
        super.inputInfo();

        this.id = Person.IDENTITY_ID;

        do {
            System.out.println("Chọn loại bạn đọc:");
            Menu.typeReader();
            try {
                int choose = Integer.parseInt(Constants.scanner.nextLine());
                switch (choose) {
                    case 1:
                        this.typeReader = Constants.STUDENT;
                        break;
                    case 2:
                        this.typeReader = Constants.GRADUATE_STUDENTS;
                        break;
                    case 3:
                        this.typeReader = Constants.TEACHER;
                        break;
                    default:
                        System.out.println("Không tồn tại loại bạn đọc mà bạn chọn! Chọn lại:");
                        break;
                }
                if (ValidateData.checkTypeReader(this.typeReader)) {
                    break;
                }
                System.out.println("Phải chọn loại bạn đọc!");
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Không đúng định dạng!");
            }
        } while (true);
    }

    public static Reader findByReaderID(int id) {
        for (int i = 0; i < Main.readers.size(); i++) {
            if (id == Main.readers.get(i).getId()) {
                return Main.readers.get(i);
            }
        }
        return null;
    }
}
