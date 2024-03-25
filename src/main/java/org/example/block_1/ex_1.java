package org.example.block_1;

public class ex_1 {
    //1. Напечатать все свойства текущего потока
    public static void main(String[] args) {

//        Thread thread = new Thread(() -> {
//            Thread currentThread1 = Thread.currentThread();
//            System.out.println("Thread Name: " + currentThread1.getName());
//            System.out.println("Thread ID: " + currentThread1.getId());
//            System.out.println("Thread Priority: " + currentThread1.getPriority());
//            System.out.println("Thread State: " + currentThread1.getState());
//        });
//        thread.start();

        // Возвращает ссылку на объект потока, выполняемый в данный момент
        Thread currentThread = Thread.currentThread();
        System.out.println("Thread Name: " + currentThread.getName());
        System.out.println("Thread ID: " + currentThread.getId());
        System.out.println("Thread Priority: " + currentThread.getPriority());
        System.out.println("Thread State: " + currentThread.getState());
    }
}

