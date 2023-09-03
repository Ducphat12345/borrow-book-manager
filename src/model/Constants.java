package model;

import java.time.LocalDate;
import java.util.Scanner;

public final class Constants {
    public static Scanner scanner = new Scanner(System.in);

    public static final String PATTERN_NAME = "\\S\\D[a-zA-Z ]*";

    public static final String PATTERN = "\\S[a-zA-Z0-9 ]*";

    public static String PATTERN_PHONE_NUMBER = "0\\d{9,10}";

    public static final int PATTERN_YEAR = LocalDate.now().getYear();

    public static final String NATURAL_SCIENCES = "Khoa học tự nhiên";

    public static final String LITERATURE_ART = "Văn học - Nghệ thuật";

    public static final String ELECTRONICS_TELECOMMUNICATION = "Điện tử viễn thông";

    public static final String INFORMATION_TECHNOLOGY = "Công nghệ thông tin";

    public static final String STUDENT = "Sinh viên";

    public static final String GRADUATE_STUDENTS = "Học viên cao học";

    public static final String TEACHER = "Giáo viên";
}
