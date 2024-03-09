package org.example.block_1.ex_11;

import java.util.Date;

public class DateThread extends Thread {
    private final Formatter formatter;

    public DateThread(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void run() {
        Date currentDate = new Date();
        String formattedDate = formatter.format(currentDate);
        System.out.println(Thread.currentThread().getName() + ": " + formattedDate);
    }
}
