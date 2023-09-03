package model;

public class ValidateData {
    public static boolean checkNameReader(String fullName) {
        return fullName != null && !fullName.isEmpty() && fullName.matches(Constants.PATTERN_NAME);
    }

    public static boolean checkAddressReader(String addressReader) {
        return addressReader != null && !addressReader.isEmpty() && addressReader.matches(Constants.PATTERN);
    }

    public static boolean checkPhoneReader(String phoneReader) {
        return phoneReader != null && !phoneReader.isEmpty() && phoneReader.matches(Constants.PATTERN_PHONE_NUMBER);
    }

    public static boolean checkTypeReader(String typeReader) {
        return typeReader != null && !typeReader.isEmpty();
    }

    public static boolean checkNameBook(String nameBook) {
        return nameBook != null && !nameBook.isEmpty() && nameBook.matches(Constants.PATTERN);
    }

    public static boolean checkAuthorBook(String authorBook) {
        return authorBook != null && !authorBook.isEmpty() && authorBook.matches(Constants.PATTERN_NAME);
    }

    public static boolean checkMajorBook(String majorBook) {
        return majorBook != null && !majorBook.isEmpty();
    }

    public static boolean checkPublishingYearBook(int year) {
        return year <= Constants.PATTERN_YEAR;
    }
}
