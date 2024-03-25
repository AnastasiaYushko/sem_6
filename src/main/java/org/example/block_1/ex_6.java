package org.example.block_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//6. То же самое, что и 4,  использовать метод Collections.synchronizedList
public class ex_6 {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread addThread = new Thread(() -> {
            int i;
            for (i = 0; i < 1000; i++) {
                list.add(new Random().nextInt());
                System.out.println("+");
                System.out.println(list.size());
            }
        });

        Thread removeThread = new Thread(() -> {
            int i;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (i = 0; i < 1000; i++) {
                if (!list.isEmpty()) {
                    list.remove(new Random().nextInt(list.size()));
                    System.out.println("-");
                    System.out.println(list.size());
                }
            }
        });

        addThread.start();
        removeThread.start();
    }
}
