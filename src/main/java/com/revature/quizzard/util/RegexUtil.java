package com.revature.quizzard.util;

public class RegexUtil {

    private RegexUtil() {
        super();
    }

    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

}
