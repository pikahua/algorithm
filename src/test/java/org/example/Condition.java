package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Condition {
    private static Lock lock = new ReentrantLock();
    private static java.util.concurrent.locks.Condition condition = lock.newCondition();
    private static boolean flag = false;
    private static int max = 10;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= max; i += 2) {
                lock.lock();
                try {
                    while (flag) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "*****" + i);
                    flag = true;
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "线程t1");

        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= max; i += 2) {
                lock.lock();
                try {
                    while (!flag) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "*****" + i);
                    flag = false;
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "线程t2");

        t1.start();
        t2.start();
    }
}


