package com.candenizgumus.constants;

import java.util.regex.Pattern;

public class Constants
{
    public static final String EMAIL_REGEX =
            "^[A-Za-z0-9]+([._%+-]?[A-Za-z0-9]+)*@" +
                    "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
}
