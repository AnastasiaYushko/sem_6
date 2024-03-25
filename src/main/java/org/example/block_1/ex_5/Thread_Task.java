package org.example.block_1.ex_5;

import java.util.List;
import java.util.Random;

public class Thread_Task implements Runnable {
    private final List<Integer> list;
    private final String f;

    public Thread_Task(List<Integer> list,String f) {
        this.list = list;
        this.f = f;
    }

    @Override
    public void run() {
        int i;
        for (i = 0; i < 10000; i++) {
            if (f.equals("add")) {
                addElement();
                System.out.println("add");
            }
            else if (f.equals("remove")) {
                removeElement();
                System.out.println("remove");
            }
        }
        try {
            Thread.sleep(100);
            System.out.println(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void addElement() {
        synchronized (list) {
            list.add(new Random().nextInt());
        }
    }

    private synchronized void removeElement() {
        synchronized (list) {
            if (!list.isEmpty()) {
                list.remove(new Random().nextInt(list.size()));
            }
        }
    }
}
