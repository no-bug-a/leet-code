package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyi
 * @date 2023-02-07 19:07
 */
public class PhilosopherProblem {

    private static final List<ReentrantLock> LOCKS;

    private static final int NUM = 5;

    static {
        LOCKS = new ArrayList<>(NUM);
        for (int i = 0; i < NUM; i++) {
            LOCKS.add(new ReentrantLock());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            new Thread(new Philosopher(i)).start();
        }
    }

    private static class Philosopher implements Runnable {

        private final int index;

        public Philosopher(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            while (true) {
                //冥想
                meditation(new Random().nextInt(1000));
                //就餐
                eat();
            }
        }

        private void eat() {
            Lock rightLock = LOCKS.get(index), leftLock = LOCKS.get((index + 1) % NUM);
            //拿起右边的筷子
            rightLock.lock();
            //拿起左边的筷子
            leftLock.lock();
            try {
                System.out.printf("哲学家 %d 吃饭\n", index);
            } finally {
                rightLock.unlock();
                leftLock.unlock();
            }

        }

        private void meditation(int random) {
            while (random-- > 0);
        }
    }
}

