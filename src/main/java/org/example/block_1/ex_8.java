package org.example.block_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

// 8.  Переписать пункт 4 этого упражнения, используя ReentrantLock
public class ex_8 {
    private static final ArrayList<Integer> list = new ArrayList<>();
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread addThread = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < 10000; i++) {
                lock.lock();
                list.add(random.nextInt(100));
                lock.unlock();
            }
        });
        Thread removeThread = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < 10000; i++) {
                lock.lock();
                if (!list.isEmpty()) {
                    list.remove(random.nextInt(list.size()));
                }
                lock.unlock();
            }
        });

        addThread.start();
        removeThread.start();
    }
}
