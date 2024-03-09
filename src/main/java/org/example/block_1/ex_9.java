package org.example.block_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//9. “Ping Pong” набазеReentrantLock и Conditional переменной.
public class ex_9 {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition pingCondition = lock.newCondition();
    private static final Condition pongCondition = lock.newCondition();
    private static boolean isPingTurn = true;

    public static void main(String[] args) {
        Thread pingThread = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (!isPingTurn) {
                        pongCondition.await();
                    }
                    System.out.println("ping");
                    isPingTurn = false;
                    pingCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread pongThread = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (isPingTurn) {
                        pingCondition.await();
                    }
                    System.out.println("pong");
                    isPingTurn = true;
                    pongCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        pingThread.start();
        pongThread.start();
    }
}
