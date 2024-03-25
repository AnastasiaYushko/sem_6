package org.example.block_1.ex_5;

import java.util.ArrayList;

// 5. То же самое, но оба потока на базе одного и того же класса, использовать synchronized методы.
public class ex_5 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Thread addThread = new Thread(new Thread_Task(list,"add"));
        Thread removeThread = new Thread(new Thread_Task(list,"remove"));

        addThread.start();
        removeThread.start();
    }
}
