package org.example.block_1;

// 7. “PingPong”, задача - бесконечно выводить на консоль сообщения “ping” или “pong” из 2 разных потоков.
// При этом сообщения чередуются.
public class ex_7 {
    public static void main(String[] args) {
        //Монитор -  объект, который обладает как блокировкой, так и набором ожиданий.
        // В Java любой Object может служить монитором.

        //wait():освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор,
        // пока другой поток не вызовет метод notify()

        //notify(): продолжает работу потока, у которого ранее был вызван метод wait()

        Object lock = new Object();

        Thread pingThread = new Thread(() -> {
            //вызывает бесконечный цикл
            while (true) {
                synchronized (lock) {
                    lock.notify();
                    System.out.println("ping");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread pongThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    lock.notify();
                    System.out.println("pong");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        pingThread.start();
        pongThread.start();
    }
}
