package org.example.block_1;

import java.util.ArrayList;
import java.util.Random;

// 4.В основном потоке создать ArrayList<Integer>. Запустить 2 потока на базе разных классов
// один поток 10000 раз добавляет в список случайное целое число,
// другой 10000 раз удаляет элемент по случайному индексу.
// Использовать внешний synchronized блок

public class ex_4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Thread addThread = new Thread(() -> {
            int i;
            for (i=0; i < 10000; i++) {
                synchronized (list) {
                    list.add(new Random().nextInt());
                        System.out.println("+");
                }
            }
            try {
                Thread.sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread removeThread = new Thread(() -> {
            int i;
            for (i=0; i < 10000; i++) {
                synchronized (list) {
                    if (!list.isEmpty()) {
                        list.remove(new Random().nextInt(list.size()));
                            System.out.println("-");
                    }
                }
            }
            try {
                Thread.sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        addThread.start();
        removeThread.start();
    }
}
