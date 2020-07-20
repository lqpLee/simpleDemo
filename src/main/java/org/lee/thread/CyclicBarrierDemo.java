package org.lee.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 *
 * </p>
 *
 * @author liqp
 * @since 2020-02-13
 */
public class CyclicBarrierDemo {

    static class TaskThread extends Thread {

        CyclicBarrier barrier;

        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " 到达栅栏 A");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");

                Thread.sleep(2000);
                System.out.println(getName() + " 到达栅栏 B");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String getA() {
        return "a";
    }

    public static void main(String[] args) {
        System.out.println(3|4);
    }
}
