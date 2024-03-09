package org.example.block_1.ex_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 5. То же самое, но оба потока на базе одного и того же класса, использовать synchronized методы.
public class ex_5 {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Runnable task = new Thread_Task(list);

        Thread addThread = new Thread(task);
        Thread removeThread = new Thread(task);

        addThread.start();
        removeThread.start();
    }
}
