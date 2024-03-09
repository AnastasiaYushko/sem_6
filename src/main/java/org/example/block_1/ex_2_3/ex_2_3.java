package org.example.block_1.ex_2_3;

public class ex_2_3 {
    public static void main(String[] args) {
        //2. Создать новый поток и дождаться его окончания в первичном потоке
        Thread thread1 = new Thread(new MyThread1());
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Создать 3 новых потока и дождаться окончания их всех в первичном потоке
        Thread thread2 = new Thread(new MyThread2());
        Thread thread3 = new Thread(new MyThread3());
        Thread thread4 = new Thread(new MyThread4());

        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
