package org.example.block_1.ex_2_3;

public class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Поток 1 запущен");
        try {
            Thread.sleep(1000); // Имитация работы потока
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поток 1 завершен");
    }
}
