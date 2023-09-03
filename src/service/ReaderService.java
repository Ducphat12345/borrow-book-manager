package service;

import main.Main;
import model.Constants;
import model.Person;
import model.Reader;

public class ReaderService {

    public static void addNewReader() {
        System.out.println("Nhập số lượng bạn đọc mà bạn muốn thêm:");
        try {
            int amount = Integer.parseInt(Constants.scanner.nextLine());
            for (int i = 0; i < amount; i++) {
                System.out.println("Nhập thông tin bạn đọc thứ " + (i + 1));
                Reader reader = new Reader();
                reader.inputInfo();
                Main.readers.add(reader);
                System.out.println("Thêm thành công!");
                Person.IDENTITY_ID++;
            }
            System.out.println("Danh sách các bạn đọc là:");
            showListReader();
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Không đúng định dạng, nhập lại:");
        }
    }

    public static void showListReader() {
        for (int i = 0; i < Main.readers.size(); i++) {
            System.out.println(Main.readers.get(i));
        }
    }
}
