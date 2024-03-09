package org.example.block_1;

// 7. “PingPong”, задача - бесконечно выводить на консоль сообщения “ping” или “pong” из 2 разных потоков.
// При этом сообщения чередуются.
public class ex_7 {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread pingThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println("ping");
                    lock.notify();
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
                    System.out.println("pong");
                    lock.notify();
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
