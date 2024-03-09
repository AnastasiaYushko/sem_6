package org.example.block_1;

public class ex_1 {
    //1. Напечатать все свойства текущего потока
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            System.out.println("Thread Name: " + currentThread.getName());
            System.out.println("Thread ID: " + currentThread.getId());
            System.out.println("Thread Priority: " + currentThread.getPriority());
            System.out.println("Thread State: " + currentThread.getState());
            System.out.println("Thread Group: " + currentThread.getThreadGroup().getName());
        });
        thread.start();
    }
}

