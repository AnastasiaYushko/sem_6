package org.example.block_1.ex_4;

import java.util.ArrayList;
import java.util.Random;

public class Thread_RemoveTask implements Runnable {
    private final ArrayList<Integer> list;
    private final Random random = new Random();

    public Thread_RemoveTask(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (list) {
                if (!list.isEmpty()) {
                    list.remove(random.nextInt(list.size()));
                }
            }
        }
    }
}
