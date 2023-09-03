package model;

public abstract class Person implements InputData {
    public static int IDENTITY_ID = 10000;
    private String fullName;
    private String address;
    private String phoneNumber;

    public Person() {
    }

    public Person(String fullName, String address, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "fullName='" + fullName + ", address='" + address + ", phoneNumber='" + phoneNumber;
    }

    @Override
    public void inputInfo() {
        do {
            System.out.println("Nhập tên bạn đọc:");
            this.fullName = Constants.scanner.nextLine();
            if (ValidateData.checkNameReader(fullName)) {
                break;
            }
            System.out.println("Tên bạn đọc không hợp lệ và không được để trống!");
        } while (true);

        do {
            System.out.println("Nhập địa chỉ bạn đọc:");
            this.address = Constants.scanner.nextLine();
            if (ValidateData.checkAddressReader(this.address)) {
                break;
            }
            System.out.println("Địa chỉ không hợp lệ và không được để trống!");
        } while (true);

        do {
            System.out.println("Nhập số điện thoại bạn đọc:");
            this.phoneNumber = Constants.scanner.nextLine();
            if (ValidateData.checkPhoneReader(this.phoneNumber)) {
                break;
            }
            System.out.println("Số điện thoại không hợp lệ và không được để trống!");
        } while (true);
    }
}
