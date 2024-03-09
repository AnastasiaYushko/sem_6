package org.example.block_1.ex_11;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Formatter {
    private final SimpleDateFormat sdf;

    public Formatter(String pattern) {
        this.sdf = new SimpleDateFormat(pattern);
    }

    public String format(Date date) {
        return sdf.format(date);
    }
}
