package org.example.block_1.ex_5;

import java.util.List;
import java.util.Random;

public class Thread_Task implements Runnable {
    private final List<Integer> list;
    private final Random random = new Random();

    public Thread_Task(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            addElement();
            removeElement();
        }
    }

    private synchronized void addElement() {
        list.add(random.nextInt(100));
    }

    private synchronized void removeElement() {
        if (!list.isEmpty()) {
            list.remove(random.nextInt(list.size()));
        }
    }
}
