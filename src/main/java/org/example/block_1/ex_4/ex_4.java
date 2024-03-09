package org.example.block_1.ex_4;

import java.util.ArrayList;

// 4.В основном потоке создать ArrayList<Integer>. Запустить 2 потока на базе разных классов
// один поток 10000 раз добавляет в список случайное целое число,
// другой 10000 раз удаляет элемент по случайному индексу.
// Использовать внешний synchronized блок

public class ex_4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Runnable addTask = new Thread_AddTask(list);
        Runnable removeTask = new Thread_RemoveTask(list);

        Thread addThread = new Thread(addTask);
        Thread removeThread = new Thread(removeTask);

        addThread.start();
        removeThread.start();
    }
}
