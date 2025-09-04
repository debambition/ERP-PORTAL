package in.parthi.common;

import java.util.Scanner;

public class Properties {

    public static final String STATUS_AVAILABLE = "AVAILABLE";
    public static final String STATUS_RETURNED = "RETURNED";
    public static final String STATUS_SOLD = "SOLD OUT";
    private static Scanner sc = Properties.getSacnnerInstance();

    public static Scanner getSacnnerInstance() {
        return sc;
    }
}
