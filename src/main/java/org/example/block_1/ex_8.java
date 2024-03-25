package org.example.block_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

// 8.  Переписать пункт 4 этого упражнения, используя ReentrantLock
public class ex_8 {
    private static final ArrayList<Integer> list = new ArrayList<>();
    //Блокировка повторного входа
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                //Блокирует
                lock.lock();
                try {
                    list.add(new Random().nextInt());
                    System.out.println("+");
                }
                finally {
                    //Снимает блокировку
                    lock.unlock();
                }
            }
        });
        Thread removeThread = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    if (!list.isEmpty()) {
                        list.remove(new Random().nextInt(list.size()));
                        System.out.println("-");
                    }
                }
                finally {
                    lock.unlock();
                }
            }
        });

        addThread.start();
        removeThread.start();
    }
}
