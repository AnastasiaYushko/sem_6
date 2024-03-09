package org.example.block_1.ex_6;

import java.util.List;
import java.util.Random;

public class RemoveTask_Thread implements Runnable {
    private final List<Integer> list;
    private final Random random = new Random();

    public RemoveTask_Thread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (!list.isEmpty()) {
                list.remove(random.nextInt(list.size()));
            }
        }
    }
}
