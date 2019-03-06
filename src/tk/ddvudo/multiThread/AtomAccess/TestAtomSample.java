package tk.ddvudo.multiThread.AtomAccess;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestAtomSample {
    private static int value = 0;
    private static AtomicInteger atomicValue = new AtomicInteger();
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        int number = 100000;
        Thread[] ts1 = new Thread[number];
        for (int i = 0; i < number; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        if (lock.tryLock(1, TimeUnit.SECONDS)) {
                            value++;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        condition.signalAll();
                        lock.unlock();
                    }
                }
            };
            t.start();
            ts1[i] = t;
        }

        //等待这些线程全部结束
        for (Thread t : ts1) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.printf("%d个线程进行value++后，value的值变成:%d%n", number, value);
        Thread[] ts2 = new Thread[number];
        for (int i = 0; i < number; i++) {
            Thread t = new Thread() {
                public void run() {
                    atomicValue.incrementAndGet();
                }
            };
            t.start();
            ts2[i] = t;
        }

        //等待这些线程全部结束
        for (Thread t : ts2) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行atomicValue.incrementAndGet();后，atomicValue的值变成:%d%n", number, atomicValue.intValue());
    }
}
