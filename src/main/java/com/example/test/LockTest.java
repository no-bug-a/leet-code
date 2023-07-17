package com.example.test;



import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyi
 * @date 2023-02-07 10:08
 */
public class LockTest {
    private static final Lock lockA = new ReentrantLock();
    private static final Lock lockB = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(() -> {
            lockA.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 获取锁");
                TimeUnit.MILLISECONDS.sleep(1);
                lockB.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " 不应该能获取到锁B");
                } finally {
                    lockB.unlock();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lockA.unlock();
            }
        }, "线程A").start();
        new Thread(() -> {
            lockB.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 获取锁");
                TimeUnit.MILLISECONDS.sleep(1);
                lockA.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " 不应该能获取到锁A");
                } finally {
                    lockA.unlock();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
               lockB.unlock();
            }
        }, "线程B").start();
    }
}
